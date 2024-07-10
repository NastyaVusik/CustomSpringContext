package org.example.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Anastasiya Vusik
 */

@Documented
@Target({METHOD, TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface IntensiveComponent {

    String message() default "IntensiveComponent creates bean";
}
