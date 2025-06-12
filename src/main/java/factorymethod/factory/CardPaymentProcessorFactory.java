package factorymethod.factory;

import factorymethod.payment.CardPaymentProcessor;
import factorymethod.payment.PaymentProcessor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
/**
 * 카드 결제용 Processor를 생성하는 구체 팩토리
 */
public class CardPaymentProcessorFactory extends PaymentProcessorFactory{
    @Override
    public PaymentProcessor createProcessor() {
        return new CardPaymentProcessor();
    }
}
