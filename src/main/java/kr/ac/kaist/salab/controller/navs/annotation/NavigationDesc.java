package kr.ac.kaist.salab.controller.navs.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by gyeongmin on 2016. 3. 2..
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface NavigationDesc {
    String id();
    String name();
    String link();
    int order() default 0;
}
