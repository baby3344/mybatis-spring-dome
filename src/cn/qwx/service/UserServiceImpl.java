package cn.qwx.service;

import cn.qwx.dao.user.UserMapper;
import cn.qwx.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
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
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findUsersWithConditon(User user) {
        try{
            return userMapper.getUserList(user);  //调用userMapper接口引用
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Boolean addNewsUser(User user) {
        Boolean result=false;
        try {
            if(userMapper.add(user)==1)
                result=true;

        }catch (Exception e){
            e.printStackTrace();
            throw  e;
        }
        return result;
    }
}
