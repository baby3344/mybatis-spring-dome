package cn.qwx.test;

import cn.qwx.entity.Bill;
import cn.qwx.service.Bill.BillService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BillTest {
    private static Logger logger=Logger.getLogger(BillTest.class);

    @Test
    public void Test(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        BillService billService=(BillService)ctx.getBean("billService");
        List<Bill> billList=billService.BillList("豆",6,2);
        for (Bill bill:billList) {
            logger.debug("订单编码："+bill.getBillCode()+",商品名称："+bill.getProductName()+",供应商名称："+bill.getProviderName()
            +"，账单金额："+bill.getTotalPrice()+"，是否付款："+bill.getIsPayment()+",创建时间："+bill.getCreationDate());
        }
    }
}
