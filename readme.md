# 🎯 DesignPattern

자바 기반으로 GoF 디자인 패턴을 직접 구현하고,
각 패턴의 **생성 시점, 구조, 쓰레드 안전성, 테스트 가능성**을 **코드 기반으로 학습**하는 프로젝트입니다.

---

## 🧠 학습 방식

- 각 디자인 패턴을 `패키지 단위`로 구분
- 구현 코드는 `main/java`
- 테스트 코드는 `test/java`
- 테스트 기반 학습을 통해 **로딩 시점, 멀티스레드 안정성, 인스턴스 비교** 등 직접 검증

---

## ✅ 현재 구현된 패턴

| 패턴 이름 | 구현 클래스 | 특징 |
|-----------|-------------|------|
| Singleton (Eager) | `SingletonEagerStatic` | 클래스 로딩 시점 즉시 생성, thread-safe |
| Singleton (Lazy + Double-Checked Locking) | `SingletonLazyDoubleCheckedLocking` | getInstance 호출 시점 생성, 동기화 비용 최소화 |
| Singleton (Static Inner Class) | `SingletonLazyStaticInner` | JVM의 클래스 로딩 특성 활용, 가장 추천되는 방식 중 하나 |
| Factory Method | `PaymentProcessorFactory` | 결제 수단에 따라 Processor 객체를 생성 |
| Abstract Factory | `PaymentFactory` | 관련된 객체군(결제 + 영수증)을 세트로 생성 |


---

## 🧪 예시 테스트: Singleton 로딩 비교

```java
// 클래스만 로딩하고, 인스턴스 생성은 생략
Class.forName("creational.singleton.SingletonLazyStaticInner");
```

### 팩토리 메서드 사용 예

```java
PaymentService service = new PaymentService();
service.executePayment(new CardPaymentProcessorFactory(), 10000);
```
