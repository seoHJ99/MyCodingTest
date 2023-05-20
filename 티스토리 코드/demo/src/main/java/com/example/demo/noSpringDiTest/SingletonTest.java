package com.example.demo.noSpringDiTest;

public class SingletonTest {

    // static 키워드를 통해 프로그램 실행시 자신의 인스턴스 생성
    public static final SingletonTest singletonInstance = new SingletonTest();

    // private 상태 메소드는 현재 클래스 내부에서만 사용 가능함으로 외부에서 인스턴스 생성 불가
    private SingletonTest() {
    }

    // get 메소드를 통해 조회 가능
    public SingletonTest getSingletonInstance(){
        return singletonInstance;
    }
}
