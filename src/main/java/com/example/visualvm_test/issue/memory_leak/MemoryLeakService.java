package com.example.visualvm_test.issue.memory_leak;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MemoryLeakService {

    private static final List<byte[]> memoryLeakList = new ArrayList<>();

    public void generateLeak() {
        // 1MB 크기의 데이터를 리스트에 추가 (의도적 누수)
        memoryLeakList.add(new byte[1024 * 1024]);
        log.info("현재 누적 객체 수: {}", memoryLeakList.size());
    }
}