package Tester;

import java.util.*;
import Generator.CocktailGenerator;
import Logger.Logger;
import MVC.Model.*;

public class CollectionTester {

    public static void testArrayList(int size, Logger logger) {
        List<BaseCocktail> list = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            BaseCocktail bc = CocktailGenerator.generateRandomCocktail();
            long start = System.nanoTime();
            list.add(bc);
            long elapsed = System.nanoTime() - start;
            logger.logOperation("add", i, elapsed);
        }

        int removeCount = size / 10;
        for (int i = 0; i < removeCount; i++) {
            int idx = rand.nextInt(list.size());
            long start = System.nanoTime();
            try {
                list.remove(idx);
                long elapsed = System.nanoTime() - start;
                logger.logOperation("remove", idx, elapsed);
            } catch (Exception e) {
                logger.logError(e.getMessage());
            }
        }
    }

    public static void testHashMap(int size, Logger logger) {
        Map<Integer, BaseCocktail> map = new HashMap<>();
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            BaseCocktail bc = CocktailGenerator.generateRandomCocktail();
            long start = System.nanoTime();
            map.put(i, bc);
            long elapsed = System.nanoTime() - start;
            logger.logOperation("put", i, elapsed);
        }

        int replaceCount = size / 10;
        for (int i = 0; i < replaceCount; i++) {
            int key = rand.nextInt(size);
            BaseCocktail bc = CocktailGenerator.generateRandomCocktail();
            long start = System.nanoTime();
            try {
                if (map.containsKey(key)) {
                    map.replace(key, bc);
                    long elapsed = System.nanoTime() - start;
                    logger.logOperation("replace", key, elapsed);
                }
            } catch (Exception e) {
                logger.logError(e.getMessage());
            }
        }
    }
}