/*
package com.haozi.context;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ComponentScanBeanDefinitionParser;

import java.util.Set;

*/
/**
 * Created by James on 2016/1/4 0004.
 *//*

public class MyBeanDefinitionReader implements MyBeanDefinitionStringReader {

    ComponentScanBeanDefinitionParser parser = new ComponentScanBeanDefinitionParser();

    private BeanDefinitionParserDelegate delegate;

    @Override
    public void registerBeanDefinitions(String packageToScan) throws BeanDefinitionStoreException {

    }


    void doRegisterBeanDefinitions(String packageToScan){
        BeanDefinitionParserDelegate parent = this.delegate;
        this.delegate = createDelegate(getReaderContext(), root, parent);

       */
/* if (this.delegate.isDefaultNamespace(root)) {
            String profileSpec = root.getAttribute(PROFILE_ATTRIBUTE);
            if (StringUtils.hasText(profileSpec)) {
                String[] specifiedProfiles = StringUtils.tokenizeToStringArray(
                        profileSpec, BeanDefinitionParserDelegate.MULTI_VALUE_ATTRIBUTE_DELIMITERS);
                if (!getReaderContext().getEnvironment().acceptsProfiles(specifiedProfiles)) {
                    return;
                }
            }
        }*//*



        parseBeanDefinitions(packageToScan, this.delegate);


        this.delegate = parent;
    }

    void parseBeanDefinitions(String packageToScan,BeanDefinitionParserDelegate delegate){

        ClassPathBeanDefinitionScanner scanner = configureScanner(parserContext, element);
        Set<BeanDefinitionHolder> beanDefinitions = scanner.doScan(packageToScan);
    }
}
*/
