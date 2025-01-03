package com.example.visualvm_test.issue.inadequate_gc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class GcService {

    public void performGcIntensiveTask() {
        for (int i = 0; i < 100; i++) {
            // 리스트 세팅
            List<Integer> numbers = new ArrayList<>();

            for (int j = 0; j < 10_000; j++) {
                numbers.add(j);
            }

            // 간단한 연산
            int sum = numbers.stream().mapToInt(Integer::intValue).sum();
            log.info("현재 작업 연산값: {}", sum);

            // 메모리 제거
            numbers.clear();
        }
    }
}
