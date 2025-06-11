package singleton;

import static org.junit.jupiter.api.Assertions.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class SingletonEagerStaticTest {

    @Test
    void testEagerLoading() throws ClassNotFoundException {
        log.info("testEagerLoading() 시작");
        // SingletonEagerStatic 클래스 로딩 - 로딩 시점에 생성자까지 호출됨
        Class.forName("singleton.SingletonEagerStatic");
        log.info("SingletonEagerStatic loaded");

        SingletonEagerStatic instance = SingletonEagerStatic.getInstance();
        assertNotNull(instance);
        log.info("testEagerLoading() 종료");
    }

    @Test
    void testLazyLoading() throws ClassNotFoundException {
        log.info("testLazyLoading() 시작");
        // SingletonLazyDoubleCheckedLocking 클래스 로딩
        Class.forName("singleton.SingletonLazyDoubleCheckedLocking");
        log.info("SingletonLazyDoubleCheckedLocking loaded");

        // 실제 getInstance() 호출시에 생성자 호출되며, 인스턴스화 진행
        SingletonLazyDoubleCheckedLocking instance = SingletonLazyDoubleCheckedLocking.getInstance();
        assertNotNull(instance);
        log.info("testLazyLoading() 종료");
    }

    @Test
    void testLazyStaticInnerLoading() throws ClassNotFoundException {
        log.info("testLazyStaticInnerLoading() 시작");
        // SingletonLazyStaticInner 클래스 로딩
        Class.forName("singleton.SingletonLazyStaticInner");
        log.info("SingletonLazyStaticInner loaded");

        // 실제 getInstance() 호출시에 생성자 호출되며, 인스턴스화 진행
        SingletonLazyStaticInner instance = SingletonLazyStaticInner.getInstance();
        assertNotNull(instance);
        log.info("testLazyStaticInnerLoading() 종료");
    }
}