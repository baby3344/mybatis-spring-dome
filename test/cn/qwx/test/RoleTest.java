package cn.qwx.test;


import cn.qwx.entity.Role;
import cn.qwx.service.role.RoleService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class RoleTest {
    private static Logger logger=Logger.getLogger(RoleTest.class);

    @Test
    public void testRoleList(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        RoleService roleService=(RoleService) ctx.getBean("roleService");
        List<Role> rolelist=roleService.roleList("员工");
        for (Role role:rolelist) {
            logger.debug("编码号为："+role.getId()+",编码为："+role.getRoleCode()+",角色名称为："+role.getRoleName());
        }
    }

    @Test
    public void testAdd(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        RoleService roleService=(RoleService) ctx.getBean("roleService");
        Role role=new Role();
        role.setRoleName("主管");
        role.setRoleCode("SMBMS_EMPLOYEE");
        role.setCreatedBy(1);
        role.setCreationDate(new Date());
        int result=roleService.addRole(role);
        logger.debug("受影响的行数为："+result);
    }

    @Test
    public void testUpdate(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        RoleService roleService=(RoleService) ctx.getBean("roleService");
        Role role=new Role();
        role.setId(5);
        role.setRoleName("小组长");
        role.setRoleCode("SMBMS_EMPLOYEE");
        role.setModifyBy(1);
        role.setModifyDate(new Date());
        int result=roleService.updateRoleById(role);
        logger.debug("受影响的行数为："+result);
    }

    
}
