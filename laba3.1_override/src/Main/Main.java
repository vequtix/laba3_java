package Main;

import Logger.Logger;
import Tester.CollectionTester;

public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger("log.txt");
        int[] sizes = {10, 100, 1000, 10000, 100000};

        for (int size : sizes) {
            logger.startSession("ArrayList", size);
            CollectionTester.testArrayList(size, logger);
            logger.endSession();

            logger.startSession("HashMap", size);
            CollectionTester.testHashMap(size, logger);
            logger.endSession();
        }
        logger.close();
        System.out.println("Логи успешно записаны в log.txt");
    }
}
