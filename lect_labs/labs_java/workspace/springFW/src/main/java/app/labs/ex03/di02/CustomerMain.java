package app.labs.ex03.di02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomerMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext context 
		= new GenericXmlApplicationContext("classpath:config/di02/application-config.xml");
		
//	Customer.class 는 클래스 메타정보를 이용해서 convert 해라 라는 말 
		Customer customer = context.getBean("customer", Customer.class);
		System.out.println(customer);
		
		
		Customer customer1 = context.getBean("customer", Customer.class);
		System.out.println(customer == customer1); // true -> 주소값이 같다. 
		
		Person person1 = context.getBean(Person.class);  // id말고도 class 전체를 가져올 수 있다. 
		Person person2 = context.getBean(Person.class);
		
		System.out.println(person1 == person2); // false -> 주소값이 다르다 , prototype으로 scope를 지정했기 때문이다 
		
		context.close();

	}

}
