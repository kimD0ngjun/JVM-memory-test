package com.example.visualvm_test.issue.slow_bean_init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * 의도적인 빈 초기화 지연 -> VisualVM Profiler 활용
 */
@Slf4j
@Component
@Lazy // 스프링은 즉시 초기화가 디폴트지만, 얘는 지연 초기화 어노테이션
public class SlowInitBean {

    public SlowInitBean() throws InterruptedException {
        Thread.sleep(10_000); // 10초 지연
        log.warn("*** 느릿느릿 SlowInitBean 생성자 초기화 ***");
    }

    public void performTask() {
        log.info("*** SlowInitBean 작업 수행 ***");
    }
}
