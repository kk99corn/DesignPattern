package creational.factorymethod.service;

/**
 * 팩토리 메서드 패턴을 활용한 결제 서비스
 * <p>
 * 원하는 결제 방식의 팩토리를 주입받아 해당 Processor를 실행한다.
 * </p>
 */

import creational.factorymethod.factory.BankTransferProcessorFactory;
import creational.factorymethod.factory.CardPaymentProcessorFactory;
import creational.factorymethod.factory.EasyPayProcessorFactory;
import creational.factorymethod.factory.PaymentProcessorFactory;
import creational.factorymethod.payment.PaymentProcessor;

public class PaymentService {
    public void executePayment(PaymentProcessorFactory factory, int amount) {
        PaymentProcessor processor = factory.createProcessor();
        processor.pay(amount);
    }

    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        service.executePayment(new CardPaymentProcessorFactory(), 50000);
        service.executePayment(new EasyPayProcessorFactory(), 30000);
        service.executePayment(new BankTransferProcessorFactory(), 100000);
    }
}
