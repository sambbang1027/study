package app.labs.ex04.aop02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {

			AbstractApplicationContext context 
			= new GenericXmlApplicationContext("classpath:config/aop02/application-config.xml");
			
			HelloController controller = context.getBean("helloController", HelloController.class);
			controller.hello("정우");
			controller.goodBye("정우");
			
			context.close();

	}

}
