package creational.factorymethod;

import static org.junit.jupiter.api.Assertions.*;

import creational.factorymethod.factory.BankTransferProcessorFactory;
import creational.factorymethod.factory.CardPaymentProcessorFactory;
import creational.factorymethod.factory.EasyPayProcessorFactory;
import creational.factorymethod.factory.PaymentProcessorFactory;
import creational.factorymethod.payment.BankTransferProcessor;
import creational.factorymethod.payment.CardPaymentProcessor;
import creational.factorymethod.payment.EasyPayProcessor;
import creational.factorymethod.payment.PaymentProcessor;
import creational.factorymethod.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class PaymentProcessorFactoryTest {

    @Test
    void testCardPaymentFactory() {
        log.info("testCardPaymentFactory() 시작");
        PaymentProcessorFactory factory = new CardPaymentProcessorFactory();
        PaymentProcessor processor = factory.createProcessor();
        assertTrue(processor instanceof CardPaymentProcessor);
        log.info("testCardPaymentFactory() 종료");
    }

    @Test
    void testEasyPayFactory() {
        log.info("testEasyPayFactory() 시작");
        PaymentProcessorFactory factory = new EasyPayProcessorFactory();
        PaymentProcessor processor = factory.createProcessor();
        assertTrue(processor instanceof EasyPayProcessor);
        log.info("testEasyPayFactory() 종료");
    }

    @Test
    void testBankTransferFactory() {
        log.info("testBankTransferFactory() 시작");
        PaymentProcessorFactory factory = new BankTransferProcessorFactory();
        PaymentProcessor processor = factory.createProcessor();
        assertTrue(processor instanceof BankTransferProcessor);
        log.info("testBankTransferFactory() 종료");
    }

    @Test
    void testPaymentServiceWithFactory() {
        log.info("testPaymentServiceWithFactory() 시작");
        PaymentService service = new PaymentService();
        assertDoesNotThrow(() -> service.executePayment(new CardPaymentProcessorFactory(), 1000));
        log.info("testPaymentServiceWithFactory() 종료");
    }
}
