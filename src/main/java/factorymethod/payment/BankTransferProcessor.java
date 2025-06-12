package factorymethod.payment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BankTransferProcessor implements PaymentProcessor{
    @Override
    public void pay(int amount) {
        log.info("Paying {} bank", amount);
    }
}
