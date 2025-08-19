package app.labs.ex03.di05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		
		
		AbstractApplicationContext context 
			= new AnnotationConfigApplicationContext(AppConfig.class);
	
		EmpController controller 
			= context.getBean("empController", EmpController.class);
		
		controller.printInfo();
		
		context.close();
	
	}
}
