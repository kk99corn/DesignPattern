package factorymethod.payment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CardPaymentProcessor implements PaymentProcessor {
    @Override
    public void pay(int amount) {
        log.info("Paying {} cards", amount);
    }
}
