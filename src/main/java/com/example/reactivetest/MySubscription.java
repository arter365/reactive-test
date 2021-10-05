package com.example.reactivetest;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Iterator;

/*
구독정보(Subscription)는 2가지를 가지고 있어야 한다.
1. 구독자가 누군인가?
2. 어떤 데이터를 구독 할 것인가?
 */
public class MySubscription implements Subscription {

    private Subscriber s;
    private Iterator<Integer> its;

    public MySubscription(Subscriber s, Iterable<Integer> its) {
        this.s = s;
        this.its = its.iterator();
    }

    @Override
    public void request(long n) {
        while (n > 0) {
            // 데이터는 1~10까지인데 예를 들어 n이 20이 들어오면 hasNext()가 false가 되어서 else로 간다.
            if(its.hasNext()) {
                s.onNext(its.next());
            } else {
                s.onComplete();
                break;  // 여기서 break를 하지 않으면 n이 20이 들어왔을 때 쓸데없는 연산을 9번 더 하게 된다.
            }
            n--;
        }
    }

    @Override
    public void cancel() {

    }
}
