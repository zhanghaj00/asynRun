package com.haozi.anno;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by James on 2016/1/4 0004.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface AsynClass {

    String value() default  "";
}
