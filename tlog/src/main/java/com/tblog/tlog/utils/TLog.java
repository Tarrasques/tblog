package com.tblog.tlog.utils;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TLog {

    String operateClass();

    String operateMethod();

}
