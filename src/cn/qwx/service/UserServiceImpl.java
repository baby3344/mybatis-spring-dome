package cn.qwx.service;

import cn.qwx.dao.user.UserMapper;
import cn.qwx.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {

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
