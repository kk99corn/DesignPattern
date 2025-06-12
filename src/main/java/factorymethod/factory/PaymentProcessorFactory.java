package factorymethod.factory;

/**
 * 결제 Processor 생성을 위한 팩토리의 추상 클래스
 * <p>
 * 구체 팩토리에서 카드 결제, 계좌 이체 등 다양한 Processor를 생성한다.
 * 클라이언트는 원하는 결제 수단의 팩토리만 전달하여 결제 로직을 수행할 수 있다.
 * </p>
 */

import factorymethod.payment.PaymentProcessor;

public abstract class PaymentProcessorFactory {
    public abstract PaymentProcessor createProcessor();
}
