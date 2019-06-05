package cn.com.zybank.pe.ebank.customer_service.role;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface RoleRepository extends CrudRepository<Role,Long> {
    Set<Role> findRoleByType(RoleType system);

    List<Role> findRoleByTypeAndCustomer(RoleType customer, Long customerId);

    List<Role> findRoleByTypeOrCustomer(RoleType roleType, Long customerId);
}
