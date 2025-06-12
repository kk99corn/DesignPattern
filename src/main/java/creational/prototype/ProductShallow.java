package creational.prototype;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * ProductShallow 클래스는 GoF 디자인 패턴 중 하나인 Prototype 패턴을 구현한 예시입니다.
 * <p>
 * - 본 클래스는 clone() 메서드를 오버라이드하여 객체 복제를 제공합니다.
 * - 복제 시 내부 참조형 필드인 tags(List<String>)에 대해 얕은 복사(Shallow Copy)를 수행합니다.
 *   즉, 원본 객체와 복제 객체는 같은 리스트 인스턴스를 공유하게 됩니다.
 * </p>
 *
 * <h3>프로토타입 패턴이란?</h3>
 * <ul>
 *   <li>new 키워드 대신 clone을 통해 기존 객체를 복제하여 새로운 인스턴스를 생성하는 생성 패턴</li>
 *   <li>객체 생성 비용이 크거나, 유사한 객체를 반복적으로 생성할 때 유용함</li>
 * </ul>
 *
 * <h3>얕은 복사의 특징</h3>
 * <ul>
 *   <li>기본 필드는 값 복사, 참조형 필드는 주소만 복사됨</li>
 *   <li>복사본이 참조 필드(tags)를 수정하면 원본 객체에도 영향을 줌</li>
 *   <li>빠르게 복제할 수 있지만, 의도치 않은 부작용 발생 가능성 존재</li>
 * </ul>
 *
 * <h3>적용 예시</h3>
 * <pre>{@code
 *     ProductShallow original = new ProductShallow("상품", 10000, new ArrayList<>(List.of("HOT")));
 *     ProductShallow copied = original.clone();
 *     copied.getTags().add("LIMITED");
 * }</pre>
 *
 * <p>
 * 위 예시에서 copied 객체에 tag를 추가하면, original 객체의 tags에도 동일하게 반영됩니다.
 * (두 객체가 동일한 리스트 인스턴스를 공유하기 때문)
 * </p>
 */

@Slf4j
@Getter
@Setter
public class ProductShallow implements Cloneable {
    private String name;
    private int price;
    private List<String> tags;

    public ProductShallow(String name, int price, List<String> tags) {
        this.name = name;
        this.price = price;
        this.tags = tags;
    }

    @Override
    public ProductShallow clone() {
        try {
            return (ProductShallow)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
