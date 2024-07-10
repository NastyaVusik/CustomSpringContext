package org.example;

import org.example.context.IntensiveContext;
import org.example.service.searchService.SearchImpl;

/**
 * @author Anastasiya Vusik
 */

public class Main {
    public static void main(String[] args) {
        IntensiveContext intensiveContext = new IntensiveContext("context.properties");

        SearchImpl search = intensiveContext.getObject(SearchImpl.class);
        search.searchSomething();
    }
}
