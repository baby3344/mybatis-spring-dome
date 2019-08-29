package cn.qwx.dao.user;

import cn.qwx.dao.user.UserMapper;
import cn.qwx.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * 定义Dao接口的实现类，实现UserMapper接口
 */
public class UserMapperImpl implements UserMapper {
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> getUserList(User user) {
        return sqlSession.selectList("cn.qwx.dao.user.UserMapper.getUserList",user);
    }

    @Override
    public int add(User user) {
        return sqlSession.insert("cn.qwx.dao.user.UserMapper.add",user);
    }


}
