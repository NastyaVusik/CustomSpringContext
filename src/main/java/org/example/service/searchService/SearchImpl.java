package org.example.service.searchService;

import org.example.annotation.IntensiveComponent;

/**
 * @author Anastasiya Vusik
 */

@IntensiveComponent
public class SearchImpl implements Search{

    private String message;

    public void setMessage(String message){
        this.message = message;
    }

    @Override
    public void searchSomething() {
//        System.out.println("I'm smart method for search something interesting");
        System.out.println("message: " + message);
    }
}
