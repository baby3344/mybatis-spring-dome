package cn.qwx.service;

import cn.qwx.dao.user.UserMapper;
import cn.qwx.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    //@Resource
    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    private UserMapper userMapper;  //声明userMapper接口

    @Override
    public List<User> findUsersWithConditon(User user) {
        try{
            return userMapper.getUserList(user);  //调用userMapper接口引用
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
