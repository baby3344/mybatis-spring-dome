package cn.qwx.service.provider;

import cn.qwx.entity.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Providerervice {
   public List<Provider> providerList();

   public List<Provider> providerListByName(@Param("proName")String proName);

   public int addProvider(Provider provider);

   public int updateProvider(Provider provider);

   public int delProviderById(Integer id);
}
