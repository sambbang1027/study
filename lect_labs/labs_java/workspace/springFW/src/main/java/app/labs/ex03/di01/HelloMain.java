package app.labs.ex03.di01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {

			// 1) 
		// HelloController controller = new HelloController();
		
			// 2)  생성자 
		//HelloController controller = new HelloController(new HelloService());
		
			// 3) Setter
//		HelloController controller = new HelloController();
//		controller.setHelloService(new HelloService());
//
//		controller.hello("김정우");
		
	
		// 4) Spring DI
		//프로그램 실행 시 필요한 빈정보를 불러와서 context에 넣는다. 
		AbstractApplicationContext context 
		= new GenericXmlApplicationContext("classpath:config/di01/application-config.xml");
		
		// 5) 생성자
		HelloController controller = context.getBean("helloController", HelloController.class);
		controller.hello("김정우");
		
		// 6) Setter 
		HelloController controller2 = context.getBean("helloController2", HelloController.class);
		controller2.hello("김정우");
		
		
		HelloController controller3 = context.getBean("helloController3", HelloController.class);
		controller3.hello("김정우");
		
		context.close(); 
		// 다른 어플리케이션도 사용할 수 있게끔 close 해줘야함 
		
	}

}
