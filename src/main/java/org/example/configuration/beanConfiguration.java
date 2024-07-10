package org.example.configuration;

import org.example.annotation.IntensiveComponent;
import org.example.service.searchService.SearchImpl;

/**
 * @author Anastasiya Vusik
 */

public class beanConfiguration {

    @IntensiveComponent
    public SearchImpl search(){
        return new SearchImpl();
    }
}
