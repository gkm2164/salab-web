package kr.ac.kaist.salab.controller.navs.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by USER on 2016-03-02.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface NavigationItem {
    NavigationDesc value();
    boolean exposeOnLocalNav() default true;
}