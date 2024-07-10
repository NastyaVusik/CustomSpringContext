package org.example.service.searchService;

import org.example.annotation.IntensiveComponent;

/**
 * @author Anastasiya Vusik
 */

@IntensiveComponent
public class SearchServiceImpl implements SearchService {

    private String message;

    public void setMessage(String message){
        this.message = message;
    }

    @Override
    public Class<?> searchBeanClass(String packageName, Class<?> type) {
//        System.out.println("I'm smart method for search something interesting");
        System.out.println("message: " + message);
    }
}
