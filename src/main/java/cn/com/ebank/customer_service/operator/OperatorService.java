package cn.com.ebank.customer_service.operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class OperatorService {

    @Autowired
    private OperatorRepository repository;

    void deleteAll(Long... ids) {
        repository.deleteAll(repository.findAllById(Arrays.asList(ids)));
    }

    public Operator add(Operator newOperator) {
        return repository.save(newOperator);
    }

    public Operator findById(Long id) {
        return repository.findById(id).orElse(new Operator());
    }

    public List<Operator> findByCustomerId(Long customerId) {
        return repository.findByCustomerId(customerId);
    }
}
