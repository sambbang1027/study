package app.labs.ex04.aop02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

//class 는 분류이다. 객체지향을 잘하려면 분류를 잘하자! 
public class HelloLog {
// 클래스 메서드만 존재하는 클래스는 util class 라고 한다 
	
	
	// 정적메서드이자 클래스 메서드 Class Method
	public static  void log() {
		System.out.println(">>> Log : "+ new java.util.Date());
	}
	
	public  void resultLog(JoinPoint joinPoint, Object resultObj) {
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName(); 
		System.out.println("Result Log >> 핵심코드 메서드명 >> "+ methodName);
		System.out.println("핵심코드의 반환 값 >> "+ resultObj.toString());
	}
	
	public void exceptionLog(JoinPoint joinPoint, Exception exception) {
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		System.out.println("Exception Log >>> 핵심 코드 메서드명 >> "+ methodName);
		System.out.println("예외 발생 메세지 >>> "+ exception.getMessage() );
		
	}
	public Object aroundLog(ProceedingJoinPoint joinPoint) {
		Object result = null;
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		System.out.println("BEFORE LOG >>> 메서드 이름 >>>"+methodName);
		Object[] args = joinPoint.getArgs(); // 매개변수가 있을 때 
		try {
			result = joinPoint.proceed(); // 핵심코드 실행 
		}catch(Throwable e){
			System.out.println("Exception Log >>> 예외 메세지 >>> "+ e.getMessage());
		}finally {
			System.out.println("Finally !!!!!!!!!!");
		}
		
		
		return result;
	}
	
}
