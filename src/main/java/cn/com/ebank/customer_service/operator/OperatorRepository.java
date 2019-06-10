package cn.com.ebank.customer_service.operator;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperatorRepository extends JpaRepository<Operator,Long> {
    List<Operator> findByCustomerId(Long customerId);

}
