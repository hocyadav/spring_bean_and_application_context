import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.service.ServiceClass;

public class Test {
	public static void main(String[] args) {
		//m1 - working
		ServiceClass service = new ServiceClass();//old way
		service.fun();
		
		beanFactory__XmlBeanFactory();//m2 - working - method is deprecated but still we can get bean
		beanFactory__ClassPathXmlApplicationContext();
		applicationContext__ClassPathXmlApplicationContext();
		applicationContext__FileSystemXmlApplicationContext();
	}

	private static void beanFactory__XmlBeanFactory() {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring.xml"));//returns bean factory
		ServiceClass bean = beanFactory.getBean("service1", ServiceClass.class);
		bean.fun();
	}
	
	private static void beanFactory__ClassPathXmlApplicationContext() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring.xml");//ClassPathXmlApplicationContext return application context
		ServiceClass bean = beanFactory.getBean("service1", ServiceClass.class);
		bean.fun();
	}
	
	private static void applicationContext__ClassPathXmlApplicationContext() {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");//we can pass multiple xml file in argument
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");//make sure xml is in classpath:--> thats y method name is classpath
		ServiceClass bean = applicationContext.getBean("service1", ServiceClass.class);
		bean.fun();
	}
	private static void applicationContext__FileSystemXmlApplicationContext() {//put xml file anywhere
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("C:\\Users\\admin\\Documents\\workspace-sts-3.9.13.RELEASE\\spring_bean_n_appl_context\\src\\main\\resources\\spring.xml");
		ServiceClass bean = applicationContext.getBean("service1", ServiceClass.class);
		bean.fun();
	}

}
