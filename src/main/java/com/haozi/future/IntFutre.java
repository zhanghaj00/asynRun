package com.haozi.future;

import com.google.common.util.concurrent.*;
import com.haozi.handler.HandlerMethodMapping;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by James on 2015/11/12 0012.
 * 借口执行异步操作
 */
@Component
public class IntFutre {

    private static final ExecutorService executor = Executors.newFixedThreadPool(20);
    private static final ListeningExecutorService executorService = MoreExecutors.listeningDecorator(executor);

    @Resource
    private HandlerMethodMapping handlerMethodMapping;

    public void getRmain(){
        System.out.println(Thread.currentThread().getThreadGroup().activeCount()-2);
    }

    public  void exec(final Class<?> futureService,final Object... obj){

        ListenableFuture<Object> explosion = executorService.submit(
                new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        Method m = (Method)handlerMethodMapping.handlerMethods.get(futureService);
                        Class[] params = m.getParameterTypes();
                        Object o = null;
                        if(obj == null){
                            o = m.invoke(futureService.newInstance(),new Object[]{});
                        }else{
                            int j = obj.length;
                            Object[] ob = new Object[j];
                            for(int i=0;i<j ;i++){
                                ob[i] = obj[i];
                            }
                             o = m.invoke(futureService.newInstance(),ob);
                        }


                        System.out.println("get object::"+o);

                        try{
                            Thread.sleep(4000);
                        }catch (Exception e){

                        }
                        return o;
                    }
                });


        Futures.addCallback(explosion, new FutureCallback<Object>() {
            @Override
            public void onSuccess(Object o) {


            }

            @Override
            public void onFailure(Throwable throwable) {


            }
        });


    }

}
