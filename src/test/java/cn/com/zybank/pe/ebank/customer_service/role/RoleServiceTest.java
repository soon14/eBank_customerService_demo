package cn.com.zybank.pe.ebank.customer_service.role;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class RoleServiceTest {
    public static final long CUSTOMER_ID = 10086L;
    @Autowired
    private RoleServiceImpl service;
    private Long roleId;

    @BeforeEach
    void setUp() {
        Role role1 = new Role();
        Role role = service.addRole(role1);
        roleId = role.getId();
    }

    @AfterEach
    void tearDown() {
        service.removeRoleById(roleId);
    }

    @Test
    @DisplayName("可以查询已经保存的角色")
    void roleShouldBeQueryById() {
        Role role = service.findById(roleId);
        assertThat(role.getId()).isEqualTo(roleId);
    }

    @Test
    @DisplayName("角色被删除后，查找应该找到的是空的角色")
    void testRemove() {
        Role role = service.addRole(new Role());
        Long id = role.getId();
        assertThat(id).isNotNull();
        service.removeRoleById(id);

        Role deleted = service.findById(id);
        assertThat(deleted.getId()).isNull();
    }

    @Test
    @DisplayName("如果查询系统角色，则客户的角色应该不包括在内")
    void findSystemRoles() {
        service.addRole(new Role(RoleType.SYSTEM));
        service.addRole(new Role(RoleType.CUSTOMER));
        Set<Role> roleStream = service.loadAllSystemRole();
        assertThat(roleStream.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("仅仅查询客户的Role，不会返回系统Role")
    void findCustomerRoleOnly() {
        service.addRole(new Role(RoleType.SYSTEM));
        Role customerRole = new Role(RoleType.CUSTOMER);
        customerRole.setCustomer(CUSTOMER_ID);
        service.addRole(customerRole);

        List<Role> roleList = service.findRolesOfCustomer(CUSTOMER_ID);

        assertThat(roleList).allMatch(role -> role.getCustomer()==CUSTOMER_ID);

    }

    @Test
    @DisplayName("一个客户可用的角色，包括自定义角色和系统角色")
    void findAllAvalibleRoleForACustomer() {
        service.addRole(new Role(RoleType.SYSTEM));
        Role customerRole = new Role(RoleType.CUSTOMER);
        customerRole.setCustomer(CUSTOMER_ID);
        service.addRole(customerRole);

        List<Role> roles = service.findAvailableRolesForCustomer(CUSTOMER_ID);

        Predicate<Role> sysRole = role -> role.getType().equals(RoleType.SYSTEM);
        Predicate<Role> ownToThisCustomer = role -> role.getCustomer().equals(CUSTOMER_ID);
        assertThat(roles).allMatch(sysRole.or(ownToThisCustomer));
    }
}