package cn.com.zybank.pe.ebank.customer_service.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public Role findById(long roleId) {
        return repository.findById(roleId).orElse(new Role());
    }

    @Override
    public Role addRole(Role role) {
        return repository.save(role);
    }

    @Override
    public void removeRoleById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Set<Role> loadAllSystemRole() {
        return repository.findRoleByType(RoleType.SYSTEM);
    }

    @Override
    public List<Role> findRolesOfCustomer(Long customerId) {
        return repository.findRoleByTypeAndCustomer(RoleType.CUSTOMER,customerId);
    }

    @Override
    public List<Role> findAvailableRolesForCustomer(Long customerId) {
        return repository.findRoleByTypeOrCustomer(RoleType.SYSTEM,customerId);
    }
}
