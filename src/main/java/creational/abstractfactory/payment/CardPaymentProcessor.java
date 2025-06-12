package creational.abstractfactory.payment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CardPaymentProcessor implements PaymentProcessor {
    @Override
    public void process() {
        log.info("카드 결제를 처리합니다.");
    }
}
