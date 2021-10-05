package com.example.reactivetest;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MySubscriber implements Subscriber {

    private Subscription s;
    private int bufferSize = 3; // 한꺼번에 몇개씩 받을 것인가?
    private int bufferSize_bask = bufferSize;

    @Override
    public void onSubscribe(Subscription s) {
        System.out.println("구독자 : 구독 정보 잘받았어어");
        this.s = s;
        System.out.println("구독자 : 나 이제 신문 n개씩 줘");  // n번을 달라는게 아니라 n개씩 달라는 뜻이다.
        // 백프레셔 : 소비자가 한번에 처리할 수 있는 개수를 요청
        s.request(bufferSize);   // MySubscription의 request가 호출된다.
    }

    @Override
    public void onNext(Object o) {
        System.out.println("onNext() : " + (Integer)o);

        bufferSize--;
        if(bufferSize == 0) {
            System.out.println("하루 지남");
            bufferSize = bufferSize_bask;
            s.request(bufferSize);
        }
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("구독중 에러");
    }

    @Override
    public void onComplete() {
        System.out.println("구독 완료");
    }
}
