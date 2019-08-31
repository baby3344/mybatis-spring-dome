package cn.qwx.dao.bill;

import cn.qwx.entity.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillMapper {

    /**
     * 根据条件查询订单表
     * @param productName
     * @param providerId
     * @param isPayment
     * @return
     */
    public List<Bill> BillList(@Param("productName")String productName,@Param("providerId")Integer providerId,@Param("isPayment")Integer isPayment);
}
