package com.first.utils;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 作用：重跑
 * Created by Administrator on 2017-08-22.
 */
public class RetryListener implements IAnnotationTransformer{
    @Override
    public void transform(ITestAnnotation annotation, Class testClass,
                          Constructor testConstructor, Method testMethod){
        IRetryAnalyzer retry=annotation.getRetryAnalyzer();
        if(retry==null){
            annotation.setRetryAnalyzer(TestngRetry.class);
        }
    }
}
