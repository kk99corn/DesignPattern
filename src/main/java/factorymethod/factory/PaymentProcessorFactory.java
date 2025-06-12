package factorymethod.factory;

import factorymethod.payment.PaymentProcessor;

public abstract class PaymentProcessorFactory {
    public abstract PaymentProcessor createProcessor();
}
