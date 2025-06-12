package creational.abstractfactory.factory;

import creational.abstractfactory.payment.EasyPayProcessor;
import creational.abstractfactory.payment.PaymentProcessor;
import creational.abstractfactory.receipt.EasyPayReceiptGenerator;
import creational.abstractfactory.receipt.ReceiptGenerator;

public class EasyPayPaymentFactory implements PaymentFactory {

    @Override
    public PaymentProcessor createProcessor() {
        return new EasyPayProcessor();
    }

    @Override
    public ReceiptGenerator createReceipt() {
        return new EasyPayReceiptGenerator();
    }
}
