package org.example.testClass;

import org.example.annotation.IntensiveComponent;

/**
 * @author Anastasiya Vusik
 * Class for testing custom Spring context
 */

@IntensiveComponent
public class Class1 {

    public void run(){
        System.out.println("Bean of class " + getClass().getName() + " was created");
    }
}
