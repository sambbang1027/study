package app.labs.ex04.aop01;

//class 는 분류이다. 객체지향을 잘하려면 분류를 잘하자! 
public class HelloLog {
// 클래스 메서드만 존재하는 클래스는 util class 라고 한다 
	
	
	// 정적메서드이자 클래스 메서드 Class Method
	public static  void log() {
		System.out.println(">>> Log : "+ new java.util.Date());
	}
}
