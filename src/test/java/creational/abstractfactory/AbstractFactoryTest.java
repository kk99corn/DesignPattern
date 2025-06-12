package creational.abstractfactory;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import creational.abstractfactory.factory.CardPaymentFactory;
import creational.abstractfactory.factory.EasyPayPaymentFactory;
import creational.abstractfactory.factory.PaymentFactory;
import creational.abstractfactory.payment.CardPaymentProcessor;
import creational.abstractfactory.payment.EasyPayProcessor;
import creational.abstractfactory.payment.PaymentProcessor;
import creational.abstractfactory.receipt.CardReceiptGenerator;
import creational.abstractfactory.receipt.EasyPayReceiptGenerator;
import creational.abstractfactory.receipt.ReceiptGenerator;
import creational.abstractfactory.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class AbstractFactoryTest {
    @Test
    void testCardPaymentFactory() {
        log.info("testCardPaymentFactory() 시작");
        PaymentFactory factory = new CardPaymentFactory();
        PaymentProcessor processor = factory.createProcessor();
        ReceiptGenerator receipt = factory.createReceipt();

        assertInstanceOf(CardPaymentProcessor.class, processor);
        assertInstanceOf(CardReceiptGenerator.class, receipt);
        log.info("testCardPaymentFactory() 종료");
    }

    @Test
    void testEasyPayFactory() {
        log.info("testEasyPayFactory() 시작");
        PaymentFactory factory = new EasyPayPaymentFactory();
        PaymentProcessor processor = factory.createProcessor();
        ReceiptGenerator receipt = factory.createReceipt();

        assertInstanceOf(EasyPayProcessor.class, processor);
        assertInstanceOf(EasyPayReceiptGenerator.class, receipt);
        log.info("testEasyPayFactory() 종료");
    }

    @Test
    void testPaymentServiceExecutionWithCardFactory() {
        log.info("testPaymentServiceExecutionWithCardFactory() 시작");
        PaymentFactory factory = new CardPaymentFactory();
        PaymentService service = new PaymentService(factory);

        assertDoesNotThrow(service::executePayment);
        log.info("testPaymentServiceExecutionWithCardFactory() 종료");
    }

    @Test
    void testPaymentServiceExecutionWithEasyPayFactory() {
        log.info("testPaymentServiceExecutionWithEasyPayFactory() 시작");
        PaymentFactory factory = new EasyPayPaymentFactory();
        PaymentService service = new PaymentService(factory);

        assertDoesNotThrow(service::executePayment);
        log.info("testPaymentServiceExecutionWithEasyPayFactory() 종료");
    }
}
