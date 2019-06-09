package cn.com.zybank.pe.ebank.customer_service.account;

import cn.com.zybank.pe.ebank.customer_service.account.model.Account;
import cn.com.zybank.pe.ebank.customer_service.account.model.PermitType;
import cn.com.zybank.pe.ebank.customer_service.customer_channel.model.CustomerChannelPK;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class AccountServiceTest {

    private static final CustomerChannelPK CUSTOMER_CHANNEL_ID = new CustomerChannelPK(10086L, 1L);

    @Autowired
    private AccountService service;
    private Long id1;
    private Long id2;

    @BeforeEach
    @DisplayName("上挂一个账户到某个客户10086，渠道1；")
    void setUp() {
        id1 = service.mount(newAccount()).getId();
        id2 = service.mount(newAccount()).getId();
    }

    @AfterEach
    @DisplayName("清理上挂的账户")
    void tearDown() {
        Account byId1 = service.findById(id1);
        Account byId2 = service.findById(id2);
        Stream.of(byId1,byId2).filter(x->x.getId()!=null).forEach(x->service.unmount(x.getId()));
    }


    @Test
    @DisplayName("通过账户ID，找到账户")
    void find_by_id() {
        assertThat(service.findById(id1).getId()).isEqualTo(id1);
    }

    @Test
    @DisplayName("列出客户渠道下的所有账户")
    void list_all_account_under_a_customer_channel() {
        List<Account> accountList = service.findByCustomerChannel(CUSTOMER_CHANNEL_ID);
        assertThat(accountList).hasSize(2).containsOnly(service.findById(id1),service.findById(id2));
    }

    @Test
    @DisplayName("账户解挂后，再查询，则得到一个空账户")
    void find_by_id_if_no() {
        service.unmount(id1);
        assertThat(service.findById(id1)).isEqualTo(new Account());
    }


    private Account newAccount() {
        Account account = new Account();
        account.setAccountNumber(String.valueOf(System.currentTimeMillis()));
        account.setOnceLimit(1000);
        account.setDayAmmount(100000);
        account.setPermitType(PermitType.SEARCH);
        account.setCustomerChannelId(CUSTOMER_CHANNEL_ID);
        return account;
    }


}