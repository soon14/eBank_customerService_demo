package cn.com.zybank.pe.ebank.customer_service.customer_channel;

import cn.com.zybank.pe.ebank.customer_service.customer_channel.model.CustomerChannel;
import cn.com.zybank.pe.ebank.customer_service.customer_channel.model.CustomerChannelPK;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CustomerChannelServiceTest {

    public static final long CUSTOMER_ID = 10086L;
    public static final long CHANNEL_ID1 = 1L;
    public static final long CHANNEL_ID2 = 2L;
    @Autowired
    CustomerChannelService service;

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
    void searchFunctionsWithCustomerChannel() throws Exception {
        List<CustomerChannel> byCustomerId = service.findSignedChannelOfCustomer(CUSTOMER_ID);

        Set<Long> singedFunctions = byCustomerId.get(0).getSingedFunctions();
        System.err.println("singedFunctions!!!!!!!!!!!!!!**** = " + singedFunctions);

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
        HashSet<Long> functions = new HashSet<>();
        Arrays.stream(fId).forEach(functions::add);
        return functions;
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