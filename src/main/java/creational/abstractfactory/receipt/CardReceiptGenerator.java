package creational.abstractfactory.receipt;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CardReceiptGenerator implements ReceiptGenerator {
    @Override
    public void generate() {
        log.info("카드 영수증을 생성합니다.");
    }
}
