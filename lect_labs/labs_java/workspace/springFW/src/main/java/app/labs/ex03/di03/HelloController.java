package app.labs.ex03.di03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

// 의존성 생성 방법 
@Controller // ->bean id는 default bean id가 적용된다 클래스명의 첫글자는 소문자 
public class HelloController {
	
	// 1) 기본 방법 - 멤버 필드 이용 
	@Autowired // Spring  빈으로 등록되지 않으면 Autowired 는 사용할 수 없음 현재 @Controller로 빈등록 되었기 때문에 사용가능 
	private IHelloService helloService;
	// 타입 기준으로 default id 설정된다 
	
//	@Autowired
//	private IHelloService niceService;

//	@Autowired
//	@Qualifier("niceService") // default id를 사용하지 않을때 사용하는 어노테이션
//	private IHelloService helloService;
	
	// 2) 생성자 이용 방법
	
	//  private final IHelloService helloService;  -> 자동 주입되지만 순환참조 하지않는 방법을 사용하는 걸 권장한다.
	//@Autowired // 생성자경우, 생성자 위에 Autowired를 준다 
	public HelloController(IHelloService helloService) {
		this.helloService = helloService;
		//this.niceService = helloService;
	}
	
	// 3) Setter
	public HelloController() {}
	//@Autowired // Setter 경우, set 위에 Autowired를 준다  
	// setter의 경우 default로 생성되지 않고 호출될때 생성된다. 
	public void setHelloService(IHelloService helloService) {
		this.helloService = helloService;
		//this.niceService = helloService;
	}
	
	public void hello(String name) {
		System.out.println("Hello Controller : " + helloService.sayHello(name));
	}
}
