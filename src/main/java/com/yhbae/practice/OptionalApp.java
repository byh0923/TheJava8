package com.yhbae.practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalApp {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        //OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
        //Duration studyDuration = spring_boot.getProgress().getStudyDuration();
        // NPE 발생
        // 보통 해결하는 방법이..
        //Progress progress = spring_boot.getProgress();
        //if(progress != null) {
            // next
        //}
        // 이 코드는 에러를 만들기 좋은 코드다.. null을 체크하는 것을 깜빡할 수 있기 때문에

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        boolean present = optional.isPresent();
        System.out.println(present);

        OnlineClass onlineClass = optional.get();
        System.out.println(onlineClass.getTitle());

        optional.ifPresent(oc -> System.out.println(oc.getTitle()));

        OnlineClass onlineClass1 = optional.orElse(createNewClass());// 있더라도 메서드는 무조건 실행함 => d이걸 대비하기 위해 orElseGet 사용
        System.out.println(onlineClass1.getTitle());
        OnlineClass onlineClass2 = optional.orElseGet(OptionalApp::createNewClass);// 이걸 대비하기 위해 orElseGet 사용 없는 경우에만 만듦.
        optional.orElseThrow(IllegalArgumentException::new);
        
        // 있다는 가정으로
        Optional<OnlineClass> optional1 = optional.filter(oc -> !oc.isClosed());

        // map
        // 맵으로 꺼내는 타입 자체가 optional 이다?
        Optional<Object> o = optional.map(OnlineClass::getId);
        System.out.println(o.isPresent());

        // flatMap
        Optional<Progress> progress = optional.flatMap(OnlineClass::getProgress);


    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New Class", false);
    }
}
