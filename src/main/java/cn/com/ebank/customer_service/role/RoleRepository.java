package cn.com.ebank.customer_service.role;

import cn.com.ebank.customer_service.role.model.SystemRole;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository  extends CrudRepository<SystemRole,Long> {

}
