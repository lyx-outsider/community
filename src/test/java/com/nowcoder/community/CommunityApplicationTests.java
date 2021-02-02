package com.nowcoder.community;

import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.security.RunAs;
import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
//添加这个注解表示接下来我们运行的代码要用这个配置类CommunityApplication.class
class CommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;
  //ApplicationContext实际上就是IoC容器
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
	@Autowired AlphaDao alphaDao;
    //测试这个容器
	@Test
	public void TestApplicationContext(){
		System.out.println(applicationContext);
		AlphaDao alphaDao=applicationContext.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());
	}

	@Test
	public void testBean(){
		AlphaService alphaService=applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
		alphaService=applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
	}

	@Test
	public void testBeanConfig(){
		SimpleDateFormat simpleDateFormat=applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}

	@Test
	public void testDi(){
		System.out.println(alphaDao.select());
	}


}
