package cn.com.zybank.pe.ebank.customer_service.account;

import cn.com.zybank.pe.ebank.customer_service.account.model.ChannelAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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


    



}