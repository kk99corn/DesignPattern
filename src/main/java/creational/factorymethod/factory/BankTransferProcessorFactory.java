package creational.factorymethod.factory;

import creational.factorymethod.payment.BankTransferProcessor;
import creational.factorymethod.payment.PaymentProcessor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
/**
 * 은행 송금용 Processor를 생성하는 구체 팩토리
 */
public class BankTransferProcessorFactory extends PaymentProcessorFactory{
    @Override
    public PaymentProcessor createProcessor() {
        return new BankTransferProcessor();
    }
}
