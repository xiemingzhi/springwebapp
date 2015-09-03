package com.mycompany;

import javax.annotation.PostConstruct;

public class SampleBeanInititalizer {

    private final SampleBean bean;

    public SampleBeanInititalizer(SampleBean bean) {
        this.bean = bean;
    }

    @PostConstruct
    public void initialize() {
    	System.out.println("going to do something");
        bean.doSomething();
    }

}
