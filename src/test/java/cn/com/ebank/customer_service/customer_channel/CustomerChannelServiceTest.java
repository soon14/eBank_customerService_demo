package cn.com.ebank.customer_service.customer_channel;

import cn.com.ebank.customer_service.customer_channel.model.CustomerChannel;
import cn.com.ebank.customer_service.customer_channel.model.CustomerChannelPK;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CustomerChannelServiceTest {


    private static final long CUSTOMER_ID = 10086L;
    private static final long CHANNEL_ID1 = 1L;
    private static final long CHANNEL_ID2 = 2L;
    @Autowired
    private CustomerChannelService service;

    @BeforeEach
    @DisplayName("一个客户签约两个渠道")
    void sign() {

        CustomerChannel customerChannel1 = createNewCustomerChannel(CHANNEL_ID1);
        CustomerChannel customerChannel2 = createNewCustomerChannel(CHANNEL_ID2);

        service.save(customerChannel1);
        service.save(customerChannel2);

    }

    @AfterEach
    void tearDown() {
        service.deleteById(new CustomerChannelPK(CUSTOMER_ID,CHANNEL_ID1));
        service.deleteById(new CustomerChannelPK(CUSTOMER_ID,CHANNEL_ID2));
    }

    @Test
    @DisplayName("通过客户ID可以查到所有签约的渠道")
    void searchByCustomerId() {
        List<CustomerChannel> channels = service.findSignedChannelOfCustomer(CUSTOMER_ID);
        assertThat(channels.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("查询一个客户渠道的所有功能")
    void searchFunctionsWithCustomerChannel() {
        List<CustomerChannel> byCustomerId = service.findSignedChannelOfCustomer(CUSTOMER_ID);

        Set<Long> singedFunctions = byCustomerId.get(0).getSingedFunctions();

        assertThat(singedFunctions).contains(1L,2L,3L);
    }

    @Test()
    @DisplayName("更新一个客户渠道的功能")
    void updateFunctionsWithCustomerChannel() {
        CustomerChannel cc1 = service.findById(new CustomerChannelPK(CUSTOMER_ID, CHANNEL_ID1));

        cc1.setSingedFunctions(functionOf(9L, 10L));
        CustomerChannel updated = service.save(cc1);

        assertThat(updated.getSingedFunctions()).contains(9L,10L);
        assertThat(updated.getId()).isEqualTo(new CustomerChannelPK(CUSTOMER_ID,CHANNEL_ID1));
    }

    private HashSet<Long> functionOf(Long... fId) {
        return new HashSet<>(Arrays.asList(fId));
    }


    private CustomerChannel createNewCustomerChannel(long channelId) {
        CustomerChannelPK id = new CustomerChannelPK(CUSTOMER_ID, channelId);
        CustomerChannel customerChannel = new CustomerChannel(id);
        customerChannel.setSingedFunctions(newFunctions());

        return customerChannel;
    }

    private HashSet<Long> newFunctions() {
        HashSet<Long> functions = functionOf(1L, 2L);
        functions.add(3L);
        return functions;
    }
}