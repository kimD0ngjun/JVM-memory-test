package com.example.visualvm_test.issue.inadequate_gc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GCController {
    @GetMapping("/gc")
    public String gcIssue() {
        // 요청마다 많은 객체 생성
        List<String> temp = new ArrayList<>();

        for (int i = 0; i < 1_000_000; i++) {
            temp.add("객체 " + i);
        }

        return "GC 작동";
    }

    /**
     * Visual GC 플러그인 활용 -> GC 옵션 바꿀 수 있으면 바꿔보기
     */
}
