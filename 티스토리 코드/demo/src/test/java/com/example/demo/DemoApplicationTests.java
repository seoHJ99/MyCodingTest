package com.example.demo;

import com.example.demo.noSpringDiTest.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class DemoApplicationTests {

	@Test
	void beanSingletonTest(){
		ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
		Alphabet alphabet1 = ac.getBean("alphabet", Alphabet.class);
		Alphabet alphabet2 = ac.getBean("alphabet", Alphabet.class);
		System.out.println("alphabet1 = " + alphabet1);
		System.out.println("alphabet2 = " + alphabet2);
	}

	@Test
	void cglibTest(){
		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
//		Alphabet a = ac.getBean("a", Alphabet.class);
//		Alphabet b = ac.getBean("b", Alphabet.class);
		TowAlphabet towAlphabet = ac.getBean("towAlphabet", TowAlphabet.class);
	}

	@Test
	void autoAppConfigTest(){
		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
		Alphabet a = ac.getBean("a", Alphabet.class);
		a.className();
	}

	@Test
	void everyBean(){
		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

	}
}
