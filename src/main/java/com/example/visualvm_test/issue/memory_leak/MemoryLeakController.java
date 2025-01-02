package com.example.visualvm_test.issue.memory_leak;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HTTP 요청 후, 메모리 사용량 증가하며 GC 미회수 객체 발생
 */
@RestController
@RequestMapping("/leak")
@RequiredArgsConstructor
public class MemoryLeakController {

    private final MemoryLeakService memoryLeakService;

    /**
     * VisualVM Heap Dump 분석 + JMeter 호출 처리
     * -> 가상 사용자수 조건이 과하면 OutOfMemoryException 발생 가능성
     */
    @GetMapping("/leak")
    public String testMemoryLeak() {
        memoryLeakService.generateLeak();
        return "메모리 누수 발생!";
    }
}

