# Spring Boot + VisualVM + JMeter 기반 메모리 테스트

## 1. 테스트 환경

- 소스 코드 : Spring Boot
- 메모리 계측 : VisualVM, IntelliJ Profiler
- 트래픽 발생 장치 : JMeter

## 2. 시나리오 및 각 테스트 분석

### 1) 빈 초기화 지연 이슈
- [Source Code](https://github.com/kimD0ngjun/JVM-memory-test/tree/main/src/main/java/com/example/visualvm_test/issue/lazy_bean_init)
- [Notion](https://github.com/kimD0ngjun/JVM-memory-test/blob/main/src/main/java/com/example/visualvm_test/issue/lazy_bean_init/notion.md)

### 2) 메모리 누수로 인한 객체 회수 누락

- [Source Code](https://github.com/kimD0ngjun/JVM-memory-test/tree/main/src/main/java/com/example/visualvm_test/issue/memory_leak)
- [Notion](https://github.com/kimD0ngjun/JVM-memory-test/blob/main/src/main/java/com/example/visualvm_test/issue/memory_leak/notion.md)

### 3) 스레드 무분별 생성 및 대기

- [Source Code](https://github.com/kimD0ngjun/JVM-memory-test/tree/main/src/main/java/com/example/visualvm_test/issue/thread_waiting)
- [Notion](https://github.com/kimD0ngjun/JVM-memory-test/blob/main/src/main/java/com/example/visualvm_test/issue/thread_waiting/notion.md)

### 4) GC 옵션에 따른 동작 분석

- [Source Code](https://github.com/kimD0ngjun/JVM-memory-test/tree/main/src/main/java/com/example/visualvm_test/issue/inadequate_gc)
- [Notion](https://github.com/kimD0ngjun/JVM-memory-test/blob/main/src/main/java/com/example/visualvm_test/issue/inadequate_gc/notion.md)
