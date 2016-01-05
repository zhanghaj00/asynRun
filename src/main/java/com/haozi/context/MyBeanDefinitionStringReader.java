package com.haozi.context;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.xml.XmlReaderContext;

/**
 * Created by James on 2016/1/4 0004.
 */
public interface MyBeanDefinitionStringReader {

    void registerBeanDefinitions(String packageToScan)
            throws BeanDefinitionStoreException;
}
