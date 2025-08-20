package app.labs.ex04.aop02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
	
	IHelloService helloService;
	
	@Autowired
	public HelloController(IHelloService helloService) {
		this.helloService = helloService;
	}
	
	
	public void hello(String name) {

		System.out.println("HelloController : " + this.helloService.sayHello(name));
		
	}
	
	public void goodBye(String name) {
		System.out.println("HelloController :" +this.helloService.sayGoodBye(name));
	}
	
}
