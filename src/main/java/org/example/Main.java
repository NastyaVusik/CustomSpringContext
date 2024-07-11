package org.example;

import org.example.context.IntensiveContext;
import org.example.service.searchService.SearchServiceImpl;
import org.example.testClass.Class1;
import org.example.testClass.Class2;

/**
 * @author Anastasiya Vusik
 * Main class to start program
 */

public class Main {
    public static void main(String[] args) {
        IntensiveContext intensiveContext = new IntensiveContext("context.properties");

        Class2 class2 = intensiveContext.getObject(Class2.class);
        class2.printSomething();
    }
}
