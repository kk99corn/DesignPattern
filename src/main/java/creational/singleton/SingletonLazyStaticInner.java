package creational.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 싱글톤 Lazy 로딩 방식 (정적 내부 클래스 기반)
 * <p>
 * - Singleton 인스턴스를 정적 내부 클래스(Holder)를 통해 지연 초기화하는 방식
 * - 외부 클래스가 로딩될 때 내부 클래스는 로딩되지 않음
 * - getInstance() 호출 시점에 Holder 클래스가 로딩되면서 인스턴스가 생성됨
 * </p>
 *
 * <h3>특징</h3>
 * <ul>
 *   <li>Lazy Initialization: 실제 사용 시점까지 인스턴스 생성 미룸</li>
 *   <li>Thread-safe: JVM의 클래스 로딩 특성을 활용해 동기화 없이도 안전</li>
 *   <li>Simple: 코드가 간결하며 가독성이 뛰어남</li>
 * </ul>
 *
 * <h3>장점</h3>
 * <ul>
 *   <li>동기화 블록 없음 → 성능 손실 없음</li>
 *   <li>클래스 로딩 시점이 인스턴스 생성 타이밍과 완벽히 일치</li>
 *   <li>Java 1.2 이후 모든 JVM에서 안전하게 동작</li>
 * </ul>
 *
 * <h3>추천 사용 케이스</h3>
 * <ul>
 *   <li>초기화 비용이 큰 객체를 실제 사용 시점까지 미루고 싶은 경우</li>
 *   <li>간결하고 안정적인 싱글톤 패턴이 필요한 모든 상황</li>
 * </ul>
 */
@Slf4j
public class SingletonLazyStaticInner {

    private SingletonLazyStaticInner() {
        log.info("SingletonLazyStaticInner 생성자 호출(Lazy)");
    }

    private static class Holder {
        private static final SingletonLazyStaticInner INSTANCE = new SingletonLazyStaticInner();
    }

    public static SingletonLazyStaticInner getInstance() {
        return Holder.INSTANCE;
    }
}
