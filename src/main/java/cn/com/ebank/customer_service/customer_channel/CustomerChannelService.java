package cn.com.ebank.customer_service.customer_channel;


import cn.com.ebank.customer_service.customer_channel.model.CustomerChannel;
import cn.com.ebank.customer_service.customer_channel.model.CustomerChannelPK;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class CustomerChannelService {

    @Autowired
    private CustomerChannelRepository repository;

    public CustomerChannel save(CustomerChannel customerChannel){
        return repository.save(customerChannel);
    }

    @Transactional(readOnly = true)
    public List<CustomerChannel> findSignedChannelOfCustomer(Long customerId){
        return repository.findById_customerId(customerId);
    }

    public void deleteById(CustomerChannelPK customerChannelPK) {
        repository.deleteById(customerChannelPK);
    }

    public CustomerChannel findById(CustomerChannelPK id) {
        return repository.findById(id).orElse(new CustomerChannel(null));
    }
}
