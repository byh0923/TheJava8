package com.yhbae.thejava8;

// 추상 메서드가 딱 하나만 있으면 그게 함수형 인터페이스다.
// 두 개 이상이면 안된다.
// 다른 형태의 함수가 있더라도 중요하지 않다 추상 메서드만 딱 하나만 있으면 된다
// @FunctionalInterface => 함수형 인터페이스라고 지정해주는 애노테이션
@FunctionalInterface
public interface RunSomething {
    int doIt(int number);

    // 자바8 부터 인터페이스임에도 불구하고 static, default 메서드 정의 가능
    static void printName() {
        System.out.println("Yhbae");
    }

    default void printAge() {
        System.out.println("31");
    }

}
