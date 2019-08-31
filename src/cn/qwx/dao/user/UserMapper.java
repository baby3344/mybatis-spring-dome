package cn.qwx.dao.user;

import cn.qwx.entity.User;

import java.util.List;

public interface UserMapper {
    public List<User> getUserList(User user);

    public int add(User user);

}
