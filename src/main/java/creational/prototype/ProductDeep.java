package creational.prototype;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * ProductDeep 클래스는 GoF 디자인 패턴 중 하나인 Prototype 패턴을 구현한 예시입니다.
 * <p>
 * - 본 클래스는 clone() 메서드를 오버라이드하여 객체 복제를 제공합니다.
 * - 특히, 내부에 존재하는 참조형 필드인 tags(List<String>)에 대해 깊은 복사(Deep Copy)를 수행함으로써
 *   원본 객체와 복제 객체 간의 내부 상태가 완전히 분리되도록 보장합니다.
 * </p>
 *
 * <h3>프로토타입 패턴이란?</h3>
 * <ul>
 *   <li>new 키워드로 객체를 생성하는 대신, 기존 객체를 복제(clone)하여 새로운 인스턴스를 생성하는 패턴</li>
 *   <li>복잡한 초기화가 필요한 객체를 효율적으로 생성할 수 있음</li>
 * </ul>
 *
 * <h3>깊은 복사의 특징</h3>
 * <ul>
 *   <li>기본 필드뿐만 아니라 참조형 필드도 별도로 복제하여 원본과 복사본이 완전히 독립됨</li>
 *   <li>복사본 수정 시 원본 객체에는 영향이 없음</li>
 * </ul>
 *
 * <h3>적용 예시</h3>
 * <pre>{@code
 *     ProductDeep original = new ProductDeep("상품", 10000, List.of("NEW", "HOT"));
 *     ProductDeep copied = original.clone();
 *     copied.getTags().add("EXCLUSIVE");
 * }</pre>
 *
 * <p>
 * 위 예시에서 copied 객체에 tag를 추가해도 original 객체의 tags는 영향을 받지 않음
 * </p>
 */

@Slf4j
@Getter
@Setter
public class ProductDeep implements Cloneable {
    private String name;
    private int price;
    private List<String> tags;

    public ProductDeep(String name, int price, List<String> tags) {
        this.name = name;
        this.price = price;
        this.tags = tags;
    }

    @Override
    public ProductDeep clone() {
        try {
            ProductDeep clone = (ProductDeep)super.clone();
            clone.tags = new ArrayList<>(tags);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
