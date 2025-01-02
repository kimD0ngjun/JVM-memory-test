package com.example.visualvm_test.issue.slow_bean_init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 의도적인 빈 초기화 지연
 */
@Slf4j
@Component
public class SlowInitBean {
    public SlowInitBean() throws InterruptedException {
        Thread.sleep(10_000); // 10초 지현
        log.warn("SlowInitBean 생성자 초기화");;
    }

    /**
     * VisualVM Profiler 활용으로 초기화 시간 분 + @Lazy 어노테이션 적용해보기
     */
}
