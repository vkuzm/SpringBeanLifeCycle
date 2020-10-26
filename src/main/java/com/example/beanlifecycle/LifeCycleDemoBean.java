package com.example.beanlifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware,
    BeanFactoryAware, ApplicationContextAware {

  public LifeCycleDemoBean() {
    System.err.println("##1## Constructor");
  }

  @Override
  public void setBeanName(String name) {
    System.err.println("##2## Bean name is: " + name);
  }

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    System.err.println("##3## Bean factory has been set");
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    System.err.println("##4## Application context has been set");
  }

  public void beforeInit() {
    System.err.println("##5## Before Init - Called by Bean Post Processor");
  }

  @PostConstruct
  public void postConstruct() {
    System.err.println("##6## Post Construct has been called");
  }

  @Override
  public void afterPropertiesSet() {
    System.err.println("##7## Bean has its properties set");
  }

  public void afterInit() {
    System.err.println("##8## After Init - Called by Bean Post Processor");
  }

  @PreDestroy
  public void preDestroy() {
    System.err.println("##9## Pre Destroy has been called");
  }

  @Override
  public void destroy() {
    System.err.println("##10## Been has been destroyed");
  }
}
