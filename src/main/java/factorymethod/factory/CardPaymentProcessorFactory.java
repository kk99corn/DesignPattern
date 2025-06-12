package factorymethod.factory;

import factorymethod.payment.CardPaymentProcessor;
import factorymethod.payment.PaymentProcessor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CardPaymentProcessorFactory extends PaymentProcessorFactory{
    @Override
    public PaymentProcessor createProcessor() {
        return new CardPaymentProcessor();
    }
}
