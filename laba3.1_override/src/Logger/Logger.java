package Logger;

import java.io.*;
import java.util.*;

public class Logger {

    private BufferedWriter writer;
    private List<Long> addTimes = new ArrayList<>();
    private List<Long> removeTimes = new ArrayList<>();
    private List<Long> putTimes = new ArrayList<>();
    private List<Long> replaceTimes = new ArrayList<>();
    private int errorCount;
    protected String currentCollection;
    protected int currentSize;

    public Logger(String fileName) {
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.err.println("Ошибка открытия лог-файла: " + e.getMessage());
        }
    }

    public void startSession(String collectionType, int size) {
        currentCollection = collectionType;
        currentSize = size;
        errorCount = 0;
        addTimes.clear();
        removeTimes.clear();
        putTimes.clear();
        replaceTimes.clear();
        writeLine("Start program: " + new Date());
        writeLine(collectionType + " size: " + size);
    }

    public void logOperation(String opType, int id, long duration) {
        writeLine(opType + ", ID = " + id + ", " + duration);
        switch (opType) {
            case "add": addTimes.add(duration); break;
            case "remove": removeTimes.add(duration); break;
            case "put": putTimes.add(duration); break;
            case "replace": replaceTimes.add(duration); break;
        }
    }

    public void logError(String message) {
        errorCount++;
        writeLine("error: " + message);
    }

    public void endSession() {
        writeLine("Errors count: " + errorCount);
        if (!addTimes.isEmpty()) writeSummary("add", addTimes);
        if (!removeTimes.isEmpty()) writeSummary("remove", removeTimes);
        if (!putTimes.isEmpty()) writeSummary("put", putTimes);
        if (!replaceTimes.isEmpty()) writeSummary("replace", replaceTimes);
        writeLine("Finish program: " + new Date() + "\n");
        flush();
    }

    private void writeSummary(String opName, List<Long> times) {
        long total = times.stream().mapToLong(Long::longValue).sum();
        long median = median(times);
        writeLine(opName + "TotalCount = " + times.size());
        writeLine(opName + "TotalTime = " + total);
        writeLine(opName + "MedianTime = " + median);
    }

    private long median(List<Long> values) {
        Collections.sort(values);
        int middle = values.size() / 2;
        if (values.size() % 2 == 1) return values.get(middle);
        else return (values.get(middle-1) + values.get(middle)) / 2;
    }

    private void writeLine(String line) {
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Ошибка записи лога: " + e.getMessage());
        }
    }

    private void flush() {
        try {
            if(writer != null) {
                writer.flush();
            }
        } catch (IOException e) {
            System.err.println("Ошибка при flush: " + e.getMessage());
        }
    }

    public void close() {
        flush();
        try {
            if(writer != null) {
                writer.close();
            }
        } catch(IOException e) {
            System.err.println("Ошибка закрытия файла: " + e.getMessage());
        }
    }
}

