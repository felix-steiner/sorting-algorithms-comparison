package com.sac.sac;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReflectionHandlerTest {
    ReflectionHandler reflectionHandler;

    @BeforeEach
    void setUp() {
        reflectionHandler = new ReflectionHandler();
    }

    @Test
    void loadClassesWithoutPrefix() {
        Set<Class<? extends SortingAlgorithm>> classes = reflectionHandler.loadClasses(null);
        assertEquals(new HashSet<>(), classes);
    }

    @Test
    void loadClassesWithEmptyPrefix() {
        Set<Class<? extends SortingAlgorithm>> classes = reflectionHandler.loadClasses("");
        assertEquals(new HashSet<>(), classes);
    }

    @Test
    void loadClassesWithWrongPrefix() {
        Set<Class<? extends SortingAlgorithm>> classes = reflectionHandler.loadClasses("some-wrong-prefix");
        assertEquals(new HashSet<>(), classes);
    }

    @Test
    void loadClassesWithCorrectPrefix() {
        Set<Class<? extends SortingAlgorithm>> classes = reflectionHandler.loadClasses("com.sca.sca");
        assertEquals(0, classes.size());
    }

    @Test
    void constructClassesWithNull() {
        Set<SortingAlgorithm> sortingAlgorithms = reflectionHandler.constructClasses(null);
        assertEquals(new HashSet<>(), sortingAlgorithms);
    }

    @Test
    void constructClassesWithoutClasses() {
        Set<SortingAlgorithm> sortingAlgorithms = reflectionHandler.constructClasses(new HashSet<>());
        assertEquals(new HashSet<>(), sortingAlgorithms);
    }

    @Test
    void constructClassesWithCorrectClasses() {
        Set<Class<? extends SortingAlgorithm>> classes = reflectionHandler.loadClasses("com.sca.sca");
        Set<SortingAlgorithm> sortingAlgorithms = reflectionHandler.constructClasses(classes);
        assertEquals(0, sortingAlgorithms.size());
    }
}
