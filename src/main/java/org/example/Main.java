package org.example;

import org.example.context.IntensiveContext;
import org.example.testClass.Class1;
import org.example.testClass.Class2;
//import org.example.testClass.Class3;
//import org.example.testClass.Class3;

/**
 * @author Anastasiya Vusik
 * Main class to start program
 */

public class Main {
    public static void main(String[] args) {
        IntensiveContext intensiveContext = new IntensiveContext("org.example");

        Class2 class2 = intensiveContext.getObject(Class2.class);
        class2.printSomething();

        Class1 class1 = intensiveContext.getObject(Class1.class);
        class1.run();

//        Class3 class3 = intensiveContext.getObject(Class3.class);
//        class3.printSomething();
    }
}
