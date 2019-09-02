package cn.qwx.test;

import cn.qwx.entity.Bill;
import cn.qwx.service.Bill.BillService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Date;
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

    @Test
    public void testAddBill(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        BillService billService=(BillService)ctx.getBean("billService");
        Bill bill=new Bill();
        bill.setBillCode("BILL2016_019");
        bill.setProductName("香槟");
        bill.setProductDesc("酒水");
        bill.setProductUnit("瓶");
        bill.setProductCount(new BigDecimal(3000.00));
        bill.setTotalPrice(new BigDecimal(6000.00));
        bill.setIsPayment(2);
        bill.setCreatedBy(1);
        bill.setCreationDate(new Date());
        bill.setProviderId(1);
        int result=billService.addBill(bill);
        logger.info("受影响的行数为："+result);
    }

    @Test
    public void  testDelById(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        BillService billService=(BillService)ctx.getBean("billService");
        int result=billService.delById(19);
        logger.info("受影响的行数为："+result);
    }

    @Test
    public void testUpdateBill(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        BillService billService=(BillService)ctx.getBean("billService");
        Bill bill=new Bill();
        bill.setBillCode("BILL2016_019");
        bill.setProductName("可口可乐");
        bill.setProductDesc("汽水");
        bill.setProductUnit("瓶");
        bill.setProductCount(new BigDecimal(3000.00));
        bill.setTotalPrice(new BigDecimal(6000.00));
        bill.setIsPayment(2);
        bill.setMdifyDate(new Date());
        bill.setModifyBy(1);
        bill.setProviderId(1);
        bill.setId(19);
        int result=billService.updateBillById(bill);
        logger.info("受影响的行数为："+result);
    }
}
