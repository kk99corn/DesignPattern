package singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 싱글톤 Lazy 로딩 방식 (Double-Checked Locking)
 * <p>
 * - 인스턴스를 실제로 사용할 때까지 생성하지 않는 Lazy Initialization 방식
 * - 멀티스레드 환경에서도 안전하게 동작하도록 synchronized 블록과 volatile 키워드 사용
 * - getInstance() 호출 시점에만 동기화를 수행하여 성능 저하 최소화
 * </p>
 *
 * <h3>특징</h3>
 * <ul>
 *   <li>Lazy Initialization: 인스턴스를 실제로 필요할 때 생성</li>
 *   <li>Double-Checked Locking(DCL): 동기화 비용을 최소화하면서도 thread-safe 보장</li>
 *   <li>volatile: instruction reordering 방지를 위한 필수 요소</li>
 * </ul>
 *
 * <h3>주의사항</h3>
 * <ul>
 *   <li>Java 1.5 이상에서만 volatile을 통한 DCL이 안전하게 동작</li>
 *   <li>코드가 다소 복잡해 유지보수 시 실수 유의</li>
 * </ul>
 *
 * <h3>추천 사용 케이스</h3>
 * <ul>
 *   <li>인스턴스 생성 비용이 크거나, 실제 사용 시점까지 생성을 미루고 싶은 경우</li>
 *   <li>정적 초기화 방식(Eager)이 리소스를 낭비할 가능성이 있는 경우</li>
 * </ul>
 */
@Slf4j
public class SingletonLazyDoubleCheckedLocking {
    private static volatile SingletonLazyDoubleCheckedLocking instance;

    private SingletonLazyDoubleCheckedLocking() {
        log.info("SingletonLazyDoubleCheckedLocking 생성자 호출(Lazy)");
    }

    public static SingletonLazyDoubleCheckedLocking getInstance() {
        if (instance == null) {
            synchronized (SingletonLazyDoubleCheckedLocking.class) {
                if (instance == null) {
                    instance = new SingletonLazyDoubleCheckedLocking();
                }
            }
        }
        return instance;
    }
}
