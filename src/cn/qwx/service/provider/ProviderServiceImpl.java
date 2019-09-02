package cn.qwx.service.provider;

import cn.qwx.dao.provider.ProviderMapper;
import cn.qwx.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
