package com.example.visualvm_test.issue.thread_pool_blocking;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;

@Slf4j
@Service
public class BlockingThreadPoolService {

    // 스레드풀 사이즈 리미트
    private final Executor executor;

    // 커스텀 설정 빈 의존성 주입
    public BlockingThreadPoolService(@Qualifier("taskExecutor") Executor executor) {
        this.executor = executor;
    }

    public void processRequest() {
        executor.execute(() -> {
            try {
                log.info("작업 시작 - 스레드: {}", Thread.currentThread().getName());
                Thread.sleep(5000); // 의도적인 블로킹 처리
                log.info("작업 완료 - 스레드: {}", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("작업 중단됨");
            }
        });
    }
}

