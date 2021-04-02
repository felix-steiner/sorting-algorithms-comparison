package com.sac.sac;

import org.reflections.Reflections;
import org.reflections.ReflectionsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class ReflectionHandler {
    private static Logger logger = LoggerFactory.getLogger(ReflectionHandler.class);

    public ReflectionHandler() {
    }

    public Set<Class<? extends SortingAlgorithm>> loadClasses(String prefix) {
        logger.info("Loading subclasses of SortingAlgorithm with package prefix: {}", prefix);
        Reflections reflections = new Reflections(prefix);

        try {
            return reflections.getSubTypesOf(SortingAlgorithm.class);
        } catch (ReflectionsException e) {
            logger.error("An unexpected error occurred while loading classes in {}:", prefix, e);
            return new HashSet<>();
        }
    }

    public Set<SortingAlgorithm> constructClasses(Set<Class<? extends SortingAlgorithm>> classes) {
        Set<SortingAlgorithm> constructedClasses = new HashSet<>();
        if (classes == null) return constructedClasses;

        for (Class<? extends SortingAlgorithm> clazz : classes) {
            try {
                logger.info("Constructing object of {}", clazz.getName());
                constructedClasses.add((SortingAlgorithm) Class.forName(clazz.getName())
                        .getDeclaredConstructor()
                        .newInstance());
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
                logger.error("An unexpected error occurred while constructing objects:", e);
            }
        }

        return constructedClasses;
    }
}
