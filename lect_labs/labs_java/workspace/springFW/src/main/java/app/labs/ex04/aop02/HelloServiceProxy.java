package app.labs.ex04.aop02;

public class HelloServiceProxy extends HelloService {
	
		@Override
		public String sayHello(String name) {
			
			HelloLog.log(); // 공통로그 호출 
			
			
			String result = super.sayHello(name); // 부모 메서드 대신 실행 
			return result;
		}
}
