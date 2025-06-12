package creational.factorymethod.payment;

/**
 * 결제 처리를 위한 공통 인터페이스
 */

public interface PaymentProcessor {
    void pay(int amount);
}
