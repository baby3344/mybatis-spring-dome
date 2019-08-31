package cn.qwx.dao.user;

import cn.qwx.dao.user.UserMapper;
import cn.qwx.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * 定义Dao接口的实现类，实现UserMapper接口
 */
public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {

    @Override
    public List<User> getUserList(User user) {
        return super.getSqlSession().selectList("cn.qwx.dao.user.UserMapper.getUserList",user);
    }

    @Override
    public int add(User user) {
        return super.getSqlSession().insert("cn.qwx.dao.user.UserMapper.add",user);
    }


}
