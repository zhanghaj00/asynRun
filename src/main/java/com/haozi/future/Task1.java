package com.haozi.future;

import com.haozi.anno.AsynClass;
import com.haozi.anno.AsynEnum;
import com.haozi.anno.AsynFunction;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Created by James on 2016/1/4 0004.
 */
@Component
@AsynClass
public class Task1 implements InitializingBean {

    @AsynFunction(value = AsynEnum.RUNTIME)
    public void print(String i){
        System.out.println("hello world::::"+i);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
