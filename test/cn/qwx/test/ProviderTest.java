package cn.qwx.test;

import cn.qwx.entity.Provider;
import cn.qwx.service.provider.Providerervice;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class ProviderTest {
    private static Logger logger=Logger.getLogger(ProviderTest.class);

    @Test
    public void  test(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        Providerervice  providerService=(Providerervice)ctx.getBean("providerService");
        List<Provider> list=providerService.providerList();
        for (Provider provider:list){
            logger.debug("供应商编码："+provider.getProCode()+",供应商名称："+provider.getProName());
        }
    }

    @Test
    public void  test1(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        Providerervice  providerService=(Providerervice)ctx.getBean("providerService");
        List<Provider> list=providerService.providerListByName("北京");
        for (Provider provider:list){
            logger.debug("供应商编码："+provider.getProCode()+",供应商名称："+provider.getProName());
        }
    }

    @Test
    public void testAddProvider(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        Providerervice  providerService=(Providerervice)ctx.getBean("providerService");
        Provider provider=new Provider();
        provider.setProCode("CZ_GYS002");
        provider.setProName("郴州玩具厂");
        provider.setProDesc("长期合作伙伴，主营产品：小孩玩具");
        provider.setProContact("谭凝");
        provider.setProPhone("4867110");
        provider.setProAddress("郴州市升平路");
        provider.setProFax("0735-555566");
        provider.setCreatedBy(1);
        provider.setCreationDate(new Date());
        int result=providerService.addProvider(provider);
        logger.debug("添加之后受影响的行数为:"+result);
    }
}
