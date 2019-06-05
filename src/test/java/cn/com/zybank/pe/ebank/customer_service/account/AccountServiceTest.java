package cn.com.zybank.pe.ebank.customer_service.account;

import cn.com.zybank.pe.ebank.customer_service.customer_channel.model.CustomerChannelPK;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class AccountServiceTest {

    private final Long ACCOUNT_ID = 8888L;
    private static final CustomerChannelPK CUSTOMER_ACCOUNT_ID = new CustomerChannelPK(10086L, 1L);

    @Autowired
    private AccountService service;

    @BeforeEach
    void setUp() throws AccountNotFoundException {
        Account account = new Account(ACCOUNT_ID);
        account.setOnceLimit(1000);
        account.setDayAmmount(100000);
        account.setOperateType(OperateType.SEARCH);
        account.setCustomerChannelId(CUSTOMER_ACCOUNT_ID);
        service.mount(account);

        Account byId = service.findById(ACCOUNT_ID);
        assertThat(byId).isEqualTo(account);
    }

    @Test
    void name() {

    }
}