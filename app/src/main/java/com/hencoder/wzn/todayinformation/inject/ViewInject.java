package com.hencoder.wzn.todayinformation.inject;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Created by wzn on 2019/6/9.
 * 通过注解的方式，来注入Activity的布局
 */
@Retention(CLASS)//注解的保留期，
// CLASS表示该注解只保留到编译进行的时候，不会被加载到JVM中
//RUNTIME,表示注解会被保留到运行时，会被加载到JVM中，会影响性能
@Target(TYPE) //注解的作用域，
// FIELD表示可以给属性进行注解
//TYPE表示类、接口注解
public @interface ViewInject {
    int mainLayoutById() default -1;
}
