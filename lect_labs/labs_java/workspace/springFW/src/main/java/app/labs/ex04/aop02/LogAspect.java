package app.labs.ex04.aop02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // bean으로 등록하기 위해서 
@Aspect 	// 이 어노테이션만으로는 bean으로 등록되지 않는다. 
public class LogAspect {
	
		//FOJO 방식
	
	
	//핵심 코드 
	@Pointcut(value="execution(* app.labs.ex04..HelloService.sayHello(..))")
	private void helloPointCut() { }

	@Pointcut(value="execution(* app.labs.ex04..HelloService.sayGoodBye(..))")
	private void goodByePointCut() {}

	// 공통코드 Aspect + Advice : Advisor 
	@Before("helloPointCut()") // advice
	public void beforeLog(JoinPoint joinPoint) {
			System.out.println(">>>>>>log "+new java.util.Date());
	}
	
	@AfterReturning(pointcut="goodByePointCut()", returning="msg")	
	public void afterLog(JoinPoint joinPoint, Object msg) {
		System.out.println(">>>>>>log "+new java.util.Date());
		System.out.println(">>>>>>msg "+msg.toString());
	}
	
	
	@Around("helloPointCut() || goodByePointCut()")
	public Object trace(ProceedingJoinPoint joinPoint)throws Throwable {
		
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		
		System.out.println("[log]Before : "+ methodName + "  start");
		
		long startTime = System.nanoTime();
		
		Object result = null;
		
		try {
			result= joinPoint.proceed();
		}catch(Exception e) {
			System.out.println("[log]Exception : "+ methodName + e.getMessage());
		}finally {
			System.out.println("[log]Finally : "+ methodName );
		}
		
		long endTime = System.nanoTime();
		
		System.out.println("[log]After : "+ methodName + "  end");
		System.out.println("[log] : "+ (endTime - startTime) + "ns");
		
		return result;
	}
}
