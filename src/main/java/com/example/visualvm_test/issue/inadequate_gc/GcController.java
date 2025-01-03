package com.example.visualvm_test.issue.inadequate_gc;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gc")
@RequiredArgsConstructor
public class GcController {

    private final GcService gcService;

    /**
     * Visual GC 플러그인 활용 -> GC 옵션 바꿀 수 있으면 바꿔보기
     */
    @GetMapping("/test")
    public String testGcIssue() {
        gcService.performGcIntensiveTask();
        return "GC 작동";
    }
}
