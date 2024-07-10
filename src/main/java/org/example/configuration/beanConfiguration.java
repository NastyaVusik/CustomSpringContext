package org.example.configuration;

import org.example.annotation.IntensiveComponent;
import org.example.service.searchService.SearchServiceImpl;

/**
 * @author Anastasiya Vusik
 */

public class beanConfiguration {

    @IntensiveComponent
    public SearchServiceImpl search(){
        return new SearchServiceImpl();
    }
}
