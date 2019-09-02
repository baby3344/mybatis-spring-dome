package cn.qwx.test;

import cn.qwx.entity.User;
import cn.qwx.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Test
    public void Test1(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        UserService userService=(UserService)ctx.getBean("userService");
        User user=new User();
        user.setUserName("张三");
        user.setAddress("郴州");
        Boolean result=userService.addNewsUser(user);
        logger.debug("testAdd result:"+result);
    }

    @Test
    //修改
    public void testModify()throws Exception{
          ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
          UserService userService=(UserService)ctx.getBean("userService");
          User user=new User();
          user.setId(17);
          user.setUserCode("testModify");
          user.setUserName("测试用户修改");
          user.setUserPassword("0000000");
          Date birthday=new SimpleDateFormat("yyyy-MM-dd").parse("1980-10-10");
          user.setBirthday(birthday);
          user.setAddress("地址测试修改");
          user.setGender(2);
          user.setPhone("13600002222");
          user.setUserRole(2);
          user.setCreatedBy(1);
          user.setCreationDate(new Date());
          int result=userService.updateUser(user);
          logger.debug("testAdd result:"+result);
    }

    @Test
    public void testDel(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        UserService userService=(UserService)ctx.getBean("userService");
        int result=userService.delById(18);
        logger.debug("testDel result:"+result);
    }

    @Test
  public void testUpdatePwd(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        UserService userService=(UserService)ctx.getBean("userService");
        User user=new User();
        user.setUserPassword("8888888");
        user.setId(18);
        int result=userService.updatePwd(user);
        logger.debug("testDel result:"+result);
  }

}
