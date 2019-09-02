package cn.qwx.service.Bill;

import cn.qwx.dao.bill.BillMapper;
import cn.qwx.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("billService")
public class BillServiceImpl implements BillService {

    public void setBillMapper(BillMapper billMapper) {
        this.billMapper = billMapper;
    }

    @Autowired
    private BillMapper billMapper;

    public List<Bill> BillList(String productName, Integer providerId, Integer isPayment) {
        return billMapper.BillList( productName, providerId,isPayment);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public int addBill(Bill bill) {
        return billMapper.addBill(bill);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public int delById(Integer id) {
        return billMapper.delById(id);
    }
}
