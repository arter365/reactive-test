package com.example.reactivetest;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.Arrays;

public class MyPublisher implements Publisher {
    // 구독정보
    Iterable<Integer> its = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    @Override
    public void subscribe(Subscriber s) {
        System.out.println("구독자 : 신문사야 나 너희 신문 볼께");
        System.out.println("신문사 : 구독 정보를 만들어서 줄테니 기다려!!");
        MySubscription mySubscription = new MySubscription(s, its);
        // 구독자에게 구독정보를 돌려준다.
        System.out.println("신문사 : 구독 정보 생성 완료 했어! 잘받아!!");
        s.onSubscribe(mySubscription);
    }
}
