package creational.factorymethod.payment;

/**
 * 카드 결제 로직 구현체
 */

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CardPaymentProcessor implements PaymentProcessor {
    @Override
    public void pay(int amount) {
        log.info("Paying {} cards", amount);
    }
}
