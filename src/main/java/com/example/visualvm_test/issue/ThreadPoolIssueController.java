package com.example.visualvm_test.issue;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ThreadPoolIssueController {
    @GetMapping("/block")
    public String block() throws InterruptedException {
        // 요청 처리 시 의도적으로 스레드를 장시간 블로킹
        Thread.sleep(10_000);
        return "블로킹 처리!";
    }

    /**
     * VisualVM Heap Dump 체킹 + RejectedExecutionException 발생 가능성
     * -> 스레드풀 크기 확장 + HTTP 요청 타임아웃 적용
     */
}
