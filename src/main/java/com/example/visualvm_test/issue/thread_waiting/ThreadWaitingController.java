package com.example.visualvm_test.issue.thread_waiting;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thread")
@RequiredArgsConstructor
public class ThreadWaitingController {

    private final ThreadWaitingPoolService threadWaitingPoolService;

    /**
     * VisualVM Heap Dump 체킹 + 스레드풀은 RejectedExecutionException으로 효율 예외 처리?
     * -> 직접 스레드를 생성하고 대기 상태로 오래 유지시키면 생기는 악영향?
     * -> 스레드풀 크기 확장 + HTTP 요청 타임아웃 적용
     */
    @GetMapping("/test")
    public String testBlockingThreadPool() {
        for (int i = 0; i < 100; i++) {
            threadWaitingPoolService.processRequest(200);
        }
        return "스레드풀 블로킹 처리!";
    }
}
