package cn.qwx.service.Bill;

import cn.qwx.entity.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillService {

    public List<Bill> BillList(@Param("productName")String productName, @Param("providerId")Integer providerId, @Param("isPayment")Integer isPayment);
}
