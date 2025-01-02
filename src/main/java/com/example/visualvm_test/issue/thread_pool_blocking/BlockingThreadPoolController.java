package com.example.visualvm_test.issue.thread_pool_blocking;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pool")
@RequiredArgsConstructor
public class BlockingThreadPoolController {

    private final BlockingThreadPoolService blockingThreadPoolService;

    /**
     * VisualVM Heap Dump 체킹 + RejectedExecutionException 발생 가능성
     * -> 스레드풀 크기 확장 + HTTP 요청 타임아웃 적용
     */
    @GetMapping("/test")
    public String testBlockingThreadPool() {
        blockingThreadPoolService.processRequest();
        return "스레드풀 블로킹 처리!";
    }
}
