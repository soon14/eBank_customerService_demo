package cn.com.ebank.customer_service.account;

import cn.com.ebank.customer_service.account.model.ChannelAccount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class ChannelAccountServiceTest {


    @Autowired
    private ChannelAccountService service;

    public static final long CUSTOMER_ID = 10086L;
    public static final long CHANNEL_ID_1 = 1L;
    public static final String ACCOUNT_NUMBER_1 = "8888";
    public static final long CHANNEL_ID_2 = 2L;
    public static final String ACCOUNT_NUMBER_2 = "9999";
    private ChannelAccount c1a1;
    private ChannelAccount c2a1;
    private ChannelAccount c1a2;
    private ChannelAccount c2a2;


    @BeforeEach
    @DisplayName("两个渠道，两个账户，加挂成4个渠道账户")
    void setUp() {
        c1a1 = service.mount(CUSTOMER_ID, CHANNEL_ID_1, ACCOUNT_NUMBER_1);
        c1a2 = service.mount(CUSTOMER_ID, CHANNEL_ID_1, ACCOUNT_NUMBER_2);

        c2a1 = service.mount(CUSTOMER_ID, CHANNEL_ID_2, ACCOUNT_NUMBER_1);
        c2a2 = service.mount(CUSTOMER_ID, CHANNEL_ID_2, ACCOUNT_NUMBER_2);

    }

    @AfterEach
    @DisplayName("解挂")
    void tearDown() {
        service.unmount(c1a1.getId());
        service.unmount(c1a2.getId());
        service.unmount(c2a1.getId());
        service.unmount(c2a2.getId());
    }

    @Test
    @DisplayName("根据账户查找")
    void findByAccountNumber() {
        List<ChannelAccount> channelAccountList = service.findByAccountNumber(ACCOUNT_NUMBER_1);
        assertThat(channelAccountList).containsOnly(c1a1,c2a1);

        List<ChannelAccount> channelAccountList2 = service.findByAccountNumber(ACCOUNT_NUMBER_2);
        assertThat(channelAccountList2).containsOnly(c1a2,c2a2);
    }


}