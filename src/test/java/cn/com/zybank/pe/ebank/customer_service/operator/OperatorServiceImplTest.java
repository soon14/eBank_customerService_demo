package cn.com.zybank.pe.ebank.customer_service.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
class OperatorServiceImplTest {

    @Autowired
    OperatorService operatorService;

    @Test
    @DisplayName("操作员保存后，主键应该已经自动生成")
    void  shouldBeSaved() {
        Operator operator = new Operator("马化腾");
        assertThat(operator.getId()).isNull();
        operator.setOrganizationId(1000L);
        Operator savedOperator = operatorService.save(operator);
        assertThat(savedOperator.getId()).isNotNull();
        assertThat(savedOperator.getName()).isEqualTo("马化腾");
    }
}