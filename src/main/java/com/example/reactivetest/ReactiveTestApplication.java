package com.example.reactivetest;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
WebFlux = 단일스레드, 비동기 + Stream을 통해 백프레셔가 적용된 데이터만큼 간헐적 응답이 가능하다 + 데이터 소비가 끝나면 응답이 종료.
SSE 적용 (Servlet, WebFlux 둘 다 가능) = 데이터 소비가 끝나도 Stream을 계속 유지.
 */
@SpringBootApplication
public class ReactiveTestApplication {
	public static void main(String[] args) {
		MyPublisher myPublisher = new MyPublisher();	// 신문사 생성
		MySubscriber mySubscriber = new MySubscriber();	// 구독자 생성

		myPublisher.subscribe(mySubscriber);			// 구독이 시작된다.
	}
}
