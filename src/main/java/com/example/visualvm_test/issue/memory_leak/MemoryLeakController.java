package com.example.visualvm_test.issue.memory_leak;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * HTTP 요청 후, 메모리 사용량 증가하며 GC 미회수 객체 발생
 */
@RestController
@RequestMapping("/leak")
public class MemoryLeakController {
    // 누수된 메모리가 담기는 곳
    private final List<byte[]> memoryLeak = new ArrayList<>();

    @GetMapping
    public String leak() {
        // 1MB 데이터가 계속 누적
        memoryLeak.add(new byte[1024 * 1024]);
        return "메모리 누수 발생!";
    }

    /**
     * VisualVM Heap Dump 분석 + JMeter 호출 처리
     * -> 가상 사용자수 조건이 과하면 OutOfMemoryException 발생 가능성
     */
}
