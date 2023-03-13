package com.yhbae.thejava8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {
        Function<Integer, String> intToString = (i) -> "number";

        UnaryOperator<String> hi = (s) -> "hi " + s;
        // == 동일
        // static 메서드를 사용하는 방법
        UnaryOperator<String> hi2 = Greeting::hi;
        System.out.println(hi2.apply("yhBae"));

        Greeting greeting = new Greeting();
        UnaryOperator<String> hi3 = greeting::hello;

        // 생성자 만드는 방법
        Supplier<Greeting> newGreeting = Greeting::new;
        Greeting greeting1 = newGreeting.get();

        // 위와 reference는 같아보이지만 다른 생성사를 참조함.
        Function<String, Greeting> yhBaeGreeting = Greeting::new;

        // 임의 객체의 인스턴스 메소드 참조하는 방법
        // 불특정 다수 인스턴스 메서드 참조
        String[] name = {"yhbae", "yh", "hy"};

    }
}
