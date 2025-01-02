package com.example.visualvm_test.issue.lazy_bean_init;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/slow")
@RequiredArgsConstructor
public class SlowInitController {

    private final SlowInitBean slowInitBean;

    @GetMapping("/test")
    public String testLazyInit() {
        slowInitBean.performTask();
        return "느릿느릿 빈 초기화 + 작업 수행";
    }
}
