package cn.qwx.dao.provider;

import cn.qwx.entity.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderMapper {
    /**
     * 查询全部供应商
     * @return
     */
    public List<Provider> ProviderList();


    /**
     * 根据供应商名称查询供应商信息
     * @param proName
     * @return
     */
    public List<Provider> ProviderListByName(@Param("proName")String proName);

    /**
     * 添加供应商
     * @param provider
     * @return
     */
    public int addProvider(Provider provider);

    /**
     * 修改供应商
     * @param provider
     * @return
     */
    public int updateProvider(Provider provider);
}
