package com.sac.sac;

import com.google.common.base.Stopwatch;
import com.sac.sac.algorithms.SortingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("### Started Sorting Algorithms Comparison application ###");

        int min = -10000;
        int max = 10000;
        int size = 10000;
        logger.info("Generating random numbers for testing the algorithms: min. {}, max. {}, size {}", min, max, size);
        NumberGenerator numberGenerator = new NumberGenerator();
        int[] numbers = numberGenerator.generateNumbers(min, max, size);

        final ReflectionHandler reflectionHandler = new ReflectionHandler();
        Set<Class<? extends SortingAlgorithm>> classes = reflectionHandler.loadClasses("com.sac.sac.algorithms");

        Stopwatch stopwatch = Stopwatch.createUnstarted();
        for (SortingAlgorithm sa : reflectionHandler.constructClasses(classes)) {
            stopwatch.start();
            sa.sort(numbers);
            stopwatch.stop();
            logger.info("{} sorted the collection in {} ns", sa.getClass().getName(), stopwatch.elapsed().getNano());
        }
    }
}
