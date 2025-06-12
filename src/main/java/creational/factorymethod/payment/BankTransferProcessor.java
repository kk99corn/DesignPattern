package creational.factorymethod.payment;

/**
 * 계좌 이체 로직 구현체
 */

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BankTransferProcessor implements PaymentProcessor{
    @Override
    public void pay(int amount) {
        log.info("Paying {} bank", amount);
    }
}
