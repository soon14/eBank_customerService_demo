package cn.com.ebank.customer_service.role;

import cn.com.ebank.customer_service.role.model.CustomerRole;
import cn.com.ebank.customer_service.role.model.OperateType;
import cn.com.ebank.customer_service.role.model.SystemRole;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class RoleServiceTest {

    @Autowired
    RoleService service;
    private Long id1;
    private Long id2;

    @BeforeEach
    void setUp() {
        id1 = service.add(newSystemRole()).getId();

        id2 = service.add(newCustomerRole()).getId();
    }

    @AfterEach
    void tearDown() {
        service.deleteById(id1);
        service.deleteById(id2);
    }


    @Test
    @DisplayName("通过id可以找到角色对象，以便修改")
    void findById() {
        SystemRole sysRole = service.findSystemRoleById(id1);
        CustomerRole customerRoleById = service.findCustomerRoleById(id2);

        assertThat(sysRole).matches(idIs(id1));
        assertThat(customerRoleById).matches(idIs(id2));
    }



    private Predicate<SystemRole> idIs(Long id) {
        return x->x.getId().equals(id);
    }


    private CustomerRole newCustomerRole() {
        CustomerRole customerRole = new CustomerRole(10086L);
        roleInit(customerRole);
        return customerRole;
    }

    private SystemRole newSystemRole() {
        SystemRole systemRole = new SystemRole();
        roleInit(systemRole);
        return systemRole;
    }



    private void roleInit(SystemRole role) {
        role.setRoleName("手机转账制单");
        role.setOperateType(OperateType.HANDLER);
        role.setChannelId(1L);
        HashSet<Long> functionIdSet = new HashSet<>();
        functionIdSet.add(100L);
        functionIdSet.add(101L);
        role.setFunctionSet(functionIdSet);
    }
}