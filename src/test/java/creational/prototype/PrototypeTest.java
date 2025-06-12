package creational.prototype;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class PrototypeTest {
    @Test
    void testShallowCopy() {
        log.info("testShallowCopy() 시작");

        ProductShallow original = new ProductShallow("Keyboard", 15000, new ArrayList<>(List.of("electronics")));
        ProductShallow clone = original.clone();

        clone.setPrice(12000);
        clone.getTags().add("gaming");

        log.info("원본: {}", original);
        log.info("복사본: {}", clone);

        assertEquals(original.getTags().size(), clone.getTags().size()); // List 공유됨
        assertTrue(original.getTags().contains("gaming")); // 복사본 수정이 원본에 영향
        log.info("testShallowCopy() 종료");
    }

    @Test
    void testDeepCopy() {
        log.info("testDeepCopy() 시작");

        ProductDeep original = new ProductDeep("Mouse", 8000, new ArrayList<>(List.of("electronics")));
        ProductDeep clone = original.clone();

        clone.setPrice(6000);
        clone.getTags().add("wireless");

        log.info("원본: {}", original);
        log.info("복사본: {}", clone);

        assertNotEquals(original.getTags().size(), clone.getTags().size()); // List 독립적
        assertFalse(original.getTags().contains("wireless")); // 원본에는 영향 없음
        log.info("testDeepCopy() 종료");
    }
}