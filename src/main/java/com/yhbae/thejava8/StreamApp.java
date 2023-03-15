package com.yhbae.thejava8;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApp {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("yhbae");
        names.add("yhbae1");
        names.add("yhbae2");
        names.add("yhbae3");

        Stream<String> stream = names.stream().map(String::toUpperCase);

        names.forEach(System.out::println);

        for(String name : names) {
            if(name.startsWith("y")) {
                System.out.println(name.toUpperCase(Locale.ROOT));
            }
        }
        // ==> parallelStream을 사용하면 알아서 병렬적 처리를 해줌
        // parallelStream을 쓰면 무조건 빨라지는게 아니다.
        // forkjoinpool?
        List<String> collect = names.parallelStream().map(String::toUpperCase).collect(Collectors.toList());
        collect.forEach(System.out::println);

    }
}
