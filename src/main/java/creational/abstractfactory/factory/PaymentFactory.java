package creational.abstractfactory.factory;

import creational.abstractfactory.payment.PaymentProcessor;
import creational.abstractfactory.receipt.ReceiptGenerator;

public interface PaymentFactory {
    PaymentProcessor createProcessor();
    ReceiptGenerator createReceipt();
}
