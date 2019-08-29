package cn.qwx.service;

import cn.qwx.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findUsersWithConditon(User user);

    public Boolean addNewsUser(User user);
}
