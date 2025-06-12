package creational.abstractfactory.factory;

import creational.abstractfactory.payment.CardPaymentProcessor;
import creational.abstractfactory.payment.PaymentProcessor;
import creational.abstractfactory.receipt.CardReceiptGenerator;
import creational.abstractfactory.receipt.ReceiptGenerator;

public class CardPaymentFactory implements PaymentFactory {
    @Override
    public PaymentProcessor createProcessor() {
        return new CardPaymentProcessor();
    }

    @Override
    public ReceiptGenerator createReceipt() {
        return new CardReceiptGenerator();
    }
}
