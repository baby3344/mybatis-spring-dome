package cn.qwx.service.provider;

import cn.qwx.dao.provider.ProviderMapper;
import cn.qwx.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("providerService")
public class ProviderServiceImpl implements  Providerervice {

    @Autowired
    public ProviderMapper getProviderMapper() {
        return providerMapper;
    }

    public void setProviderMapper(ProviderMapper providerMapper) {
        this.providerMapper = providerMapper;
    }

    private ProviderMapper providerMapper;

    public List<Provider> providerList() {
        return providerMapper.ProviderList();
    }


    @Override
    public List<Provider> providerListByName(String proName) {
        return providerMapper.ProviderListByName(proName);
    }

    @Override
    public int addProvider(Provider provider) {
        return providerMapper.addProvider(provider);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public int updateProvider(Provider provider) {
        return providerMapper.updateProvider(provider);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public int delProviderById(Integer id) {
        return providerMapper.delProviderById(id);
    }
}
