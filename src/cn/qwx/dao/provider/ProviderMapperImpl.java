package cn.qwx.dao.provider;

import cn.qwx.entity.Provider;
import org.mybatis.spring.support.SqlSessionDaoSupport;


import java.util.List;


public class ProviderMapperImpl extends SqlSessionDaoSupport implements ProviderMapper {

    public List<Provider> ProviderList() {
        return super.getSqlSession().selectList("cn.qwx.dao.provider.ProviderMapper.ProviderList");
    }


    public List<Provider> ProviderListByName(String proName) {
        return super.getSqlSession().selectList("cn.qwx.dao.provider.ProviderMapper.ProviderListByName",proName);
    }
}
