package creational.factorymethod.factory;

import creational.factorymethod.payment.EasyPayProcessor;
import creational.factorymethod.payment.PaymentProcessor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
/**
 * 간편 결제 Processor를 생성하는 구체 팩토리
 */
public class EasyPayProcessorFactory extends PaymentProcessorFactory {
    @Override
    public PaymentProcessor createProcessor() {
        return new EasyPayProcessor();
    }
}
