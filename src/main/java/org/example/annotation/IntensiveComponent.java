package org.example.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Anastasiya Vusik
 *  * This anotation is analogue of @Bean. Classes, which are marked with it, became beans and are managed
 *  by IntensiveContext
 */

@Documented
@Target({TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface IntensiveComponent {

    String message() default "IntensiveComponent creates bean";
}
