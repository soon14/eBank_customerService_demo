package cn.com.ebank.customer_service.role;

import cn.com.ebank.customer_service.role.model.CustomerRole;
import cn.com.ebank.customer_service.role.model.SystemRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;


    public SystemRole add(SystemRole role) {
        return repository.save(role);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public SystemRole findSystemRoleById(Long id) {
        return repository.findById(id).orElse(new SystemRole());
    }

    public CustomerRole findCustomerRoleById(Long id) {
        return (CustomerRole) repository.findById(id).orElse(new CustomerRole(0L));
    }
}
