package com.example.visualvm_test.issue.thread_waiting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ThreadWaitingPoolService {

    public void processRequest(int threadCount) {
        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                try {
                    log.info("스레드 시작 - {}", Thread.currentThread().getName());
                    // 스레드를 대기 상태로 두기
                    synchronized (this) {
                        wait(); // 계속 대기 상태로 두기
                    }
                    log.info("스레드 종료 - {}", Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("스레드 중단됨", e);
                }
            }).start();
        }
    }
}

