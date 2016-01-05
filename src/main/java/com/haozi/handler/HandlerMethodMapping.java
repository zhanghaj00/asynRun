package com.haozi.handler;

import com.haozi.anno.AsynClass;
import com.haozi.anno.AsynEnum;
import com.haozi.anno.AsynFunction;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cglib.transform.MethodFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Created by James on 2016/1/4 0004.
 */

@Component
public class HandlerMethodMapping extends ApplicationObjectSupport implements InitializingBean {

    private static final String SCOPED_TARGET_NAME_PREFIX = "scopedTarget.";

    public final Map<Class<?>,Object> handlerMethods = new IdentityHashMap<Class<?>,Object>();

    public HandlerMethodMapping() {
    }

    protected void initHandlerMethods(){

        String[] beanNames = (
                getApplicationContext().getBeanNamesForType(Object.class));

        for (String beanName : beanNames) {
            if (isHandler(getApplicationContext().getType(beanName))){
                detectHandlerMethods(beanName);
            }
        }
     //   handlerMethodsInitialized(getHandlerMethods());
    }
    protected boolean isHandler(Class<?> beanType) {
        return ((AnnotationUtils.findAnnotation(beanType, AsynClass.class) != null));
    }
    public void afterPropertiesSet() throws Exception {
        initHandlerMethods();

    }

    protected void initApplicationContext(ApplicationContext context) {
        super.initApplicationContext(context);
    }

    protected void detectHandlerMethods(final Object handler) {
        Class<?> handlerType =
                (handler instanceof String ? getApplicationContext().getType((String) handler) : handler.getClass());
        // Avoid repeated calls to getMappingForMethod which would rebuild RequestMappingInfo instances
        final Class<?> userType = ClassUtils.getUserClass(handlerType);


        Method[] methods = userType.getDeclaredMethods();


        for(Method method :methods){

            if(method.isAnnotationPresent(AsynFunction.class)){

                AsynFunction anno = method.getAnnotation(AsynFunction.class);

                switch (anno.value()){
                    case RUNTIME:
                        handlerMethods.put(handlerType,method);
                        break;
                    case FAIL:
                        break;
                    case SUCCESS:
                        break;
                    default:
                        break;
                }

            }


        }



        /*for (Method method : methods) {
            registerHandlerMethod(handler, method, mappings.get(method));
        }*/
    }

    /*@Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo info = null;
        RequestMapping methodAnnotation = AnnotationUtils.findAnnotation(method, AsynClass.class);
        if (methodAnnotation != null) {
            RequestCondition<?> methodCondition = getCustomMethodCondition(method);
            info = createRequestMappingInfo(methodAnnotation, methodCondition);
            RequestMapping typeAnnotation = AnnotationUtils.findAnnotation(handlerType, RequestMapping.class);
            if (typeAnnotation != null) {
                RequestCondition<?> typeCondition = getCustomTypeCondition(handlerType);
                info = createRequestMappingInfo(typeAnnotation, typeCondition).combine(info);
            }
        }
        return info;
    }*/
}
