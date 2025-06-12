package creational.abstractfactory.receipt;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EasyPayReceiptGenerator implements ReceiptGenerator {
    @Override
    public void generate() {
        log.info("간편결제 영수증을 생성합니다.");
    }
}
