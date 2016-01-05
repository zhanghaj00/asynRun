package com.haozi.context;

import javafx.application.Application;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;

import java.io.IOException;

/**
 * Created by James on 2016/1/4 0004.
 */
public class MyPackageApplicationContext extends AbstractRefreshableApplicationContext
        implements BeanNameAware, InitializingBean {

    private boolean setIdCalled = false;

    String packageToScan;

    public MyPackageApplicationContext(){}


    public MyPackageApplicationContext(ApplicationContext context){ super(context);}

    public String getPackageToScan() {
        return packageToScan;
    }

    public void setPackageToScan(String packageToScan) {
        this.packageToScan = packageToScan;
    }

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException, IOException {

    }

    @Override
    public void setBeanName(String name) {
        if (!this.setIdCalled) {
            super.setId(name);
            setDisplayName("ApplicationContext '" + name + "'");
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (!isActive()) {
            refresh();
        }
    }
}
