package org.example.testClass;

import org.example.annotation.IntensiveComponent;

/**
 * @author Anastasiya Vusik
 * Class for testing custom Spring context
 */

@IntensiveComponent
public class Class2 {

    @IntensiveComponent
    private Class1 class1;

    public void printSomething(){

        class1.run();
        System.out.println("Class " + getClass().getName() + " became a bean too");
    }
}
