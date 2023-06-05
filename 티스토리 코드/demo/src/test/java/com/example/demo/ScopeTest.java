package com.example.demo;

import com.example.demo.scope.SingletonBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeTest {

    @Test
    void singleTonPrototypeTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        SingletonBean bean = ac.getBean(SingletonBean.class);
        SingletonBean bean2 = ac.getBean(SingletonBean.class);
        bean.test();
        bean2.test();
    }
}
