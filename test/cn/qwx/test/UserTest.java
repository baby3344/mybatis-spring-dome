package cn.qwx.test;

import cn.qwx.entity.User;
import cn.qwx.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

    private static Logger logger=Logger.getLogger(UserTest.class);

    @Test
    public void Test(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        UserService userService=(UserService)ctx.getBean("userService");
        User userCode=new User();
        userCode.setUserName("赵");
        userCode.setUserRole(3);
        List<User> userList=new ArrayList<User>();
        userList=userService.findUsersWithConditon(userCode);

        for(User user1:userList){
            logger.debug("testGetUserList userCode:"
                    +user1.getUserCode()+"  and userName:"
            +user1.getUserName()+"   and userRole:"
            +user1.getUserRole()+"   and userRoleName:"
            +user1.getUserRoleName()+"  and address:"
            +user1.getAddress());
        }
    }
}
