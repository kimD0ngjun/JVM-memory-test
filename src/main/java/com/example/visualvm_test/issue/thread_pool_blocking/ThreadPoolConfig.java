package com.example.visualvm_test.issue.thread_pool_blocking;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolConfig {

    /**
     * ThreadPoolExecutor를 Spring Bean으로 등록.
     * 스레드풀을 사용해 요청을 처리할 때의 동시성 문제를 제어.
     * 스레드풀 설정을 통해 CPU/메모리 리소스의 과도한 사용 방지.
     * @return Executor 스레드풀의 작업 실행기를 반환
     */
    @Bean
    public Executor taskExecutor() {
        return new ThreadPoolExecutor(
                5, // corePoolSize: 기본 스레드 수 (항상 유지되는 최소 스레드 수)
                5, // maximumPoolSize: 최대 스레드 수 (요청 폭주 시 최대 몇 개까지 생성할지)
                0L, // keepAliveTime: 초과된 스레드가 유지되는 시간
                TimeUnit.MILLISECONDS, // keepAliveTime의 시간 단위
                new LinkedBlockingQueue<>(10) // 작업 대기열 크기 (대기 중인 작업이 저장되는 큐)
        );
    }
}
