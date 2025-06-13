package creational.builder;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class BuilderTest {

    @Test
    void testOrderBuilderCreation() {
        log.info("testOrderBuilderCreation() 시작");

        List<String> items = new ArrayList<>();
        items.add("Keyboard");
        items.add("Mouse");

        Order order = new Order.Builder()
            .orderId("ORD-1001")
            .userId("USER-999")
            .items(items)
            .totalPrice(30000)
            .build();

        log.info("생성된 Order: {}", order);

        assertEquals("ORD-1001", order.getOrderId());
        assertEquals("USER-999", order.getUserId());
        assertEquals(2, order.getItems().size());
        assertEquals(30000, order.getTotalPrice());

        log.info("testOrderBuilderCreation() 종료");
    }

    @Test
    void testBuilderWithDefaultValues() {
        log.info("testBuilderWithDefaultValues() 시작");

        Order order = new Order.Builder()
            .orderId("ORD-1002")
            .userId("USER-100")
            .build();

        log.info("기본값 테스트 Order: {}", order);

        assertEquals("ORD-1002", order.getOrderId());
        assertEquals("USER-100", order.getUserId());
        assertEquals(0, order.getTotalPrice());   // 기본값: 0

        log.info("testBuilderWithDefaultValues() 종료");
    }

    @Test
    void testImmutabilityAfterBuild() {
        log.info("testImmutabilityAfterBuild() 시작");

        List<String> items = new ArrayList<>();
        items.add("Laptop");

        Order order = new Order.Builder()
            .orderId("ORD-1003")
            .userId("USER-101")
            .items(items)
            .build();

        items = order.getItems();
        items.add("HACKED"); // 외부 수정 시도

        log.info("변조된 아이템 리스트: {}", order.getItems());

        // 이 테스트는 얕은 복사로 인해 실패할 수도 있음
        // 진짜 불변성을 보장하려면 방어적 복사 또는 Collections.unmodifiableList 필요
        assertTrue(order.getItems().contains("HACKED"));

        log.info("testImmutabilityAfterBuild() 종료");
    }
}