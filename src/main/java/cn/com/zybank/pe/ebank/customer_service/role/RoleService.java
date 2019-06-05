package cn.com.zybank.pe.ebank.customer_service.role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Role findById(long roleId);

    Role addRole(Role role);

    void removeRoleById(Long id);

    Set<Role> loadAllSystemRole();

    List<Role> findRolesOfCustomer(Long customerId);

    List<Role> findAvailableRolesForCustomer(Long customerId);
}
