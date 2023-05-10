package com.example.demo.noSpringDiTest;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestController {
    @Test
    public void play() {
        // ApplicationContext : 스프링 컨테이너
        // new AnnotationConfigApplicationContext(Config.class) : Config클래스를 포함해, 내부에 @Bean으로
        //                                                        등록된 객체를 컨테이너에 빈으로 등록
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        // alphabet 이라는 이름으로 등록된 Alphabet 클래스의 빈을 불러옴
        Alphabet alphabet = ac.getBean("alphabet", Alphabet.class);
        Controller controller = new Controller(alphabet);
        controller.mainClassName();
    }
}
