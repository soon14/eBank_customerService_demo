package cn.com.zybank.pe.ebank.customer_service.role;

import cn.com.zybank.pe.ebank.customer_service.role.model.SystemRole;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository  extends CrudRepository<SystemRole,Long> {

}
