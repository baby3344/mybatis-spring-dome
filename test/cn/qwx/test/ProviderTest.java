package cn.qwx.test;

import cn.qwx.entity.Provider;
import cn.qwx.service.provider.Providerervice;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProviderTest {
    private static Logger logger=Logger.getLogger(ProviderTest.class);

    @Test
    public void  test(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        Providerervice  providerService=(Providerervice)ctx.getBean("providerService");
        List<Provider> list=providerService.providerList();
        for (Provider provider:list){
            logger.debug("供应商编码："+provider.getProCode());
        }
    }

    @Test
    public void  test1(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        Providerervice  providerService=(Providerervice)ctx.getBean("providerService");
        List<Provider> list=providerService.providerListByName("北京");
        for (Provider provider:list){
            logger.debug("供应商编码："+provider.getProCode());
        }
    }
}
