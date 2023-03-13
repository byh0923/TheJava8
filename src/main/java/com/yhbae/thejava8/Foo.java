package com.yhbae.thejava8;

import java.util.function.*;

public class Foo {

    public static void main(String[] args) {
        // 익명 내부 클래스라고 불렀음
        /*RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("Hello");
                System.out.println("Lambda");
            }
        };*/
        // 람다 표현식
        // 함수형 인터페이스를 보여줄 수 있는 람다 표현식
        // 위의 코드랑 동일함
        // 자바에서는 특수한 형태의 object라고 볼 수 있음.
        // 멱등성을 보장하지 못하면 함수형 프로그래밍이라고 할 수 없음.
        /*RunSomething runSomething2 = () -> System.out.println("Hello");
        runSomething2.doIt();*/


        // 상태값에 의존하기 때문에 퓨어한 함수로 볼 수 없다.
        // 또 외부의 값을 변경하려고 한다면 순수 함수로 볼 수 없다.
        int outerNumber = 100;
        RunSomething runSomething = new RunSomething() {

            int baseNumber = 10;
            // 불가능
            //outerNumber++;
            @Override
            public int doIt(int number) {
                return number + baseNumber;
            }
        };

        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));

        Function<Integer, Integer> plus10_2 = (i) -> i+10;
        System.out.println(plus10_2);

        // 조합
        Function<Integer, Integer> muliply2 = (i) -> i * 2;
        System.out.println(muliply2);

        // 10을 더하기 전에 먼저 곱하겠다
        // compose => 함수가 2개가 있을 때 compose의 파라미터에 있는 파라미터 먼저 실행하고 + 앞의 함수 실행
        Function<Integer, Integer> muliply2AndPlust10 = plus10.compose(muliply2);
        System.out.println(muliply2AndPlust10.apply(2));

        // andthen 첫번째 함수를 실행하고 . 뒤의 함수를 실행
        plus10.andThen(muliply2).apply(2);

        // BiFunction apply랑 비슷한데 입력값을 2개 받음
        // Consumer
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        // supplier => 받아 올 값의 타임을 정의함
        Supplier<Integer> get10 =() -> 10;
        System.out.println(get10.get());

        // predicate => 인자 값을 하나 받아서 true, false를 return해 주는 함수인터페이스
        Predicate<String> startWithYh = (s) -> s.startsWith("yhBae");

        // Nu => 입력한 값과 리턴 값이 같을 때 UnaryOperator=> function과 동일
        // BinaryOperation -> BiFunction 특수한 형태로 입력 값의 type이 같은 때 사용

        // 바디가 한줄이면 생략해도 된다.
        Supplier<Integer> get11 = () -> 10;

        BinaryOperator<Integer> sum = (a, b) -> a+b;

        Foo foo = new Foo();
        foo.run();

    }

    private void run() {
        //local 변수를 참조한다고 하면 이 로컬 variable이 캡쳐가 된다.

        int baseNumber = 10;

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber);
            }
        }

        // 익명클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {

            @Override
            public void accept(Integer baseNumber) {
                // 파라미터의 baseNumber가 위의 baseNumber를 가린다 => 쉐도잉
                System.out.println(baseNumber);
            }
        };

        // 로컬 클래스와 익명클래스는 {} scope이 새로운 스콥인데 람다는 아니다.

        // 람다
        // 하지만 람다는 같은 scope다 그래서 동일한 이름의 변수를 정의할 수 없다.
        // effective final이 아닌 경우에도 참조할 수 없다.
        IntConsumer printInt = (i) -> System.out.println(i);
        
        printInt.accept(10);


    }
}
