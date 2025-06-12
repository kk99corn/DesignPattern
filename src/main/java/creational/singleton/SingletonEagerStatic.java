package creational.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 싱글톤 Eager 로딩 방식 구현 클래스
 * <p>
 * - 클래스 로딩 시점에 단 한 번 인스턴스를 생성하는 방식
 * - 멀티스레드 환경에서도 별도의 동기화 없이 안전하게 사용 가능
 * - 초기화 시점이 클래스 로딩 시점으로 고정되어 있어, Lazy Loading이 불필요한 경우 적합
 * </p>
 *
 * <h3>특징</h3>
 * <ul>
 *   <li>Thread-safe: static 초기화는 JVM이 보장하는 안전한 초기화 단계</li>
 *   <li>Simple: 코드가 간결하고 이해하기 쉬움</li>
 *   <li>미사용 시에도 인스턴스가 생성되므로 메모리 낭비 우려가 있음</li>
 * </ul>
 *
 * <h3>추천 사용 케이스</h3>
 * <ul>
 *   <li>애플리케이션 시작과 동시에 반드시 필요한 경우</li>
 *   <li>인스턴스 생성 비용이 적거나 무시해도 되는 경우</li>
 * </ul>
 */
@Slf4j
public class SingletonEagerStatic {
    private static final SingletonEagerStatic instance = new SingletonEagerStatic();

    private SingletonEagerStatic() {
        log.info("SingletonEagerStatic 생성자 호출(Eager)");
    }

    public static SingletonEagerStatic getInstance() {
        return instance;
    }
}
