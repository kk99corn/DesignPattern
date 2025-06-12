package factorymethod.factory;

import factorymethod.payment.BankTransferProcessor;
import factorymethod.payment.PaymentProcessor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BankTransferProcessorFactory extends PaymentProcessorFactory{
    @Override
    public PaymentProcessor createProcessor() {
        return new BankTransferProcessor();
    }
}
