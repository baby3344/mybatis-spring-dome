package cn.qwx.dao.user;

import cn.qwx.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public List<User> getUserList(User user);

    public int add(User user);

    public  int updateUser(User user);

    public int delById(int id);

    public int updatePwd(User user);

}
