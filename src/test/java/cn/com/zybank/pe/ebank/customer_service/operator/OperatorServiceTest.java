package cn.com.zybank.pe.ebank.customer_service.operator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class OperatorServiceTest {

    public static final long CUSTOMER_ID1 = 10086L;
    public static final String NAME = "张三";
    public static final long CUSTOMER_ID2 = 10010L;

    @Autowired
    OperatorService service;

    private Long id1;
    private Long id2;

    @BeforeEach
    void setUp() {
        id1 = service.add(newOperator(CUSTOMER_ID1)).getId();
        id2 = service.add(newOperator(CUSTOMER_ID2)).getId();
    }



    @AfterEach
    void tearDown() {
        service.deleteAll(id1,id2);
    }

    @Test
    void find_by_id() {
        Operator byId = service.findById(id1);
        assertThat(byId).matches(id_is(id1).and(nameIs(NAME)));
    }

    @Test
    void find_by_customerId() {
        List<Operator> byCustomerId = service.findByCustomerId(CUSTOMER_ID1);

    }



    private Predicate<Operator> nameIs(String name) {
        return x -> x.getName().equals(name);
    }

    private Predicate<Operator> id_is(Long id) {
        return x -> x.getId().equals(id);
    }

    private Operator newOperator(Long customerId) {
        Operator operator = new Operator();
        operator.setName(NAME);
        operator.setCustomerId(customerId);
        return operator;
    }


}