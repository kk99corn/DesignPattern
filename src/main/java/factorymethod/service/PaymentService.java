package factorymethod.service;

import factorymethod.factory.BankTransferProcessorFactory;
import factorymethod.factory.CardPaymentProcessorFactory;
import factorymethod.factory.EasyPayProcessorFactory;
import factorymethod.factory.PaymentProcessorFactory;
import factorymethod.payment.PaymentProcessor;

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
