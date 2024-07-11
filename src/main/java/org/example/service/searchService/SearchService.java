package org.example.service.searchService;

import java.util.Set;

/**
 * @author Anastasiya Vusik
 * Interface for searching something
 */

public interface SearchService {
    Class<?> searchClass(String packageName, Class<?> type);

    Set<Class<?>> findAllClasses(String packageName);
}
