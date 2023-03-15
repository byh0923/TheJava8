package com.yhbae.thejava8;

public interface Too {

    void printName();

    // 인터페이스에 추상 메서드가 추가되면 구현체에 다 에러가 발생함
    // 이런 일을 막기 위해 default 키워드 사용해서 사용 가능
    /**
     * @implSpec 이 구현체는....
     * */
    default void printNameUpperCase() {
        System.out.println(getName());
    }

    String getName();


}
