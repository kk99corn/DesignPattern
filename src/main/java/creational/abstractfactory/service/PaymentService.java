package creational.abstractfactory.service;

import creational.abstractfactory.factory.CardPaymentFactory;
import creational.abstractfactory.factory.EasyPayPaymentFactory;
import creational.abstractfactory.factory.PaymentFactory;
import creational.abstractfactory.payment.PaymentProcessor;
import creational.abstractfactory.receipt.ReceiptGenerator;

public class PaymentService {
    private final PaymentProcessor processor;
    private final ReceiptGenerator receipt;

    public PaymentService(PaymentFactory factory) {
        this.processor = factory.createProcessor();
        this.receipt = factory.createReceipt();
    }

    public void executePayment() {
        processor.process();
        receipt.generate();
    }

    public static void main(String[] args) {
        PaymentFactory factory = new CardPaymentFactory();
        PaymentService service = new PaymentService(factory);
        service.executePayment();

        System.out.println("=== ===");

        PaymentFactory easyPayFactory = new EasyPayPaymentFactory();
        PaymentService easyService = new PaymentService(easyPayFactory);
        easyService.executePayment();
    }
}
