package cn.qwx.service.Bill;

import cn.qwx.dao.bill.BillMapper;
import cn.qwx.entity.Bill;

import java.util.List;

public class BillServiceImpl implements BillService {

    public void setBillMapper(BillMapper billMapper) {
        this.billMapper = billMapper;
    }

    private BillMapper billMapper;

    public List<Bill> BillList(String productName, Integer providerId, Integer isPayment) {
        return billMapper.BillList( productName, providerId,isPayment);
    }
}
