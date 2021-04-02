package com.sac.sac;

import com.sac.sac.algorithms.SortingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("### Started Sorting Algorithms Comparison application ###");
        final ReflectionHandler reflectionHandler = new ReflectionHandler();

        Set<Class<? extends SortingAlgorithm>> classes = reflectionHandler.loadClasses("com.sac.sac.algorithms");

        for (SortingAlgorithm sa : reflectionHandler.constructClasses(classes)) {
            // TODO: measure time
            sa.sort(null);
        }
    }
}
