package org.example;

import org.example.context.IntensiveContext;
import org.example.service.searchService.SearchServiceImpl;

/**
 * @author Anastasiya Vusik
 */

public class Main {
    public static void main(String[] args) {
        IntensiveContext intensiveContext = new IntensiveContext("context.properties");

        SearchServiceImpl search = intensiveContext.getObject(SearchServiceImpl.class);
        search.searchSomething();
    }
}
