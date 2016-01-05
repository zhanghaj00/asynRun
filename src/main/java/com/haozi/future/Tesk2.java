package com.haozi.future;

import com.haozi.anno.AsynClass;
import com.haozi.anno.AsynEnum;
import com.haozi.anno.AsynFunction;
import org.springframework.stereotype.Component;

/**
 * Created by James on 2016/1/5 0005.
 */
@Component
@AsynClass
public class Tesk2 {

    @AsynFunction(AsynEnum.RUNTIME)
    public String  getString(String i,String j){
        System.out.println("get:"+i +"  and  get :"+j);

        return i+j;
    }
}
