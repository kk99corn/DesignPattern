package factorymethod.factory;

import factorymethod.payment.EasyPayProcessor;
import factorymethod.payment.PaymentProcessor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EasyPayProcessorFactory extends PaymentProcessorFactory {
    @Override
    public PaymentProcessor createProcessor() {
        return new EasyPayProcessor();
    }
}
