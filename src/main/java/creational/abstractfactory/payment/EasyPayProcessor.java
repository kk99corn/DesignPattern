package creational.abstractfactory.payment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EasyPayProcessor implements PaymentProcessor{
    @Override
    public void process() {
        log.info("간편결제를 처리합니다.");
    }
}
