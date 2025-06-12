package factorymethod;

import static org.junit.jupiter.api.Assertions.*;

import factorymethod.factory.BankTransferProcessorFactory;
import factorymethod.factory.CardPaymentProcessorFactory;
import factorymethod.factory.EasyPayProcessorFactory;
import factorymethod.factory.PaymentProcessorFactory;
import factorymethod.payment.BankTransferProcessor;
import factorymethod.payment.CardPaymentProcessor;
import factorymethod.payment.EasyPayProcessor;
import factorymethod.payment.PaymentProcessor;
import factorymethod.service.PaymentService;
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
