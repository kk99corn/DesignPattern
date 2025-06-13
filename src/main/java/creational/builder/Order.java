package creational.builder;

import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Order {
    private final String orderId;
    private final String userId;
    private final List<String> items;
    private final int totalPrice;

    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.userId = builder.userId;
        this.items = builder.items;
        this.totalPrice = builder.totalPrice;
    }

    public static class Builder {
        private String orderId;
        private String userId;
        private List<String> items;
        private int totalPrice;

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder items(List<String> items) {
            this.items = items;
            return this;
        }

        public Builder totalPrice(int totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
