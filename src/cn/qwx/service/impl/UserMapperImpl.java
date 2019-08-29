package cn.qwx.service.impl;

import cn.qwx.dao.user.UserMapper;
import cn.qwx.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

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


}
