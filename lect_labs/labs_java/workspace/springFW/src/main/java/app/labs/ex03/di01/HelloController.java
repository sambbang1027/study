package app.labs.ex03.di01;


// 의존성 생성 방법 
public class HelloController {
	// 1) 기본 방법 - 멤버 필드 이용 
	//private IHelloService helloService = new HelloService();
	
	// 2) 생성자 이용 방법
	private IHelloService helloService;
	
	public HelloController(IHelloService helloService) {
		this.helloService = helloService;
	}
	
	// 3) Setter
	public HelloController() {}
	public void setHelloService(IHelloService helloService) {
		this.helloService = helloService;
	}
	
	public void hello(String name) {
		System.out.println("Hello Controller : " + helloService.sayHello(name));
	}
}
