package com.springboot.demo.quartz;

import org.apache.log4j.Logger;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

/**
 * Created by wesley on 2017-03-23.
 * 把作业类交给spring管理
 */
public class QuartzJobFactory extends SpringBeanJobFactory implements ApplicationContextAware{

    public final static Logger log = Logger.getLogger(QuartzJobFactory.class);

    private transient AutowireCapableBeanFactory capableBeanFactory;

    /**
     * 覆盖父类的方法
     * @param bundle
     * @return
     * @throws Exception
     */
    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        System.out.println("createJobInstance---start");
        //调用父类的方法
        Object object = super.createJobInstance(bundle);
        System.out.println("---job--"+object.getClass().getName());
        capableBeanFactory.autowireBean(object);
        return object;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        capableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
    }
}
