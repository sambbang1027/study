package sec01_lambdaexpression.EX02_FunctionToLambdaExpression;

interface A {
	void method1();
}
interface B {
	void method2(int a);
}
interface C {
	int method3();
}
interface D{
	double method4(int a , double b);
}

public class FunctionToLambdaExpression {
	public static void main(String[] args) {
		//인터페이스의 함수 구현 -> 람다식
		// 1. 입력 X , 리턴 X
		// 1-1. 익명 이너 클래스 방식
		A a1 = new A() {
			@Override
			public void method1() {
				System.out.println("입력x 리턴x 함수");
			}
		};
		//1-2. 람다식 표현
		A a2 = () -> {System.out.println("입력x 리턴x 함수");};
		A a3 = () -> System.out.println("입력x 리턴x 함수");
		
		// 2. 입력 0, 리턴 x 
		// 2-1. 익명 이너 클래스
		B b1 = new B() {
			@Override
			public void method2(int a) {
				System.out.println("입력o 리턴x 함수");
			}
		};
		// 2-2. 람다식
		B b2 = (int a) -> {System.out.println("입력o 리턴x 함수");};
		B b3 = (a) -> {System.out.println("입력o 리턴x 함수");};
		B b4 = (a) -> System.out.println("입력o 리턴x 함수");
		B b5 = a -> System.out.println("입력o 리턴x 함수");
		
		// 3. 입력 x, 리턴o
		// 3-1. 익명 이너 클래스 
		C c1 = new C() {
			@Override 
			public int method3() {
				return 4;
			}
		};
		//3-2 람다식
		C c2 = () -> {return 4;};
		C c3 = () -> 4;
		
		// 4. 입력 o , 리턴 o 
		// 4-1 익명 이너 클래스
		D d1 = new D() {
			public double method4 (int a, double b) {
				return a+b;
			}
		};
		D d2 = (int a , double b) -> {return a + b;};
		D d3 = (a , b) -> {return a + b;};
		D d4 = (a ,b) ->  a + b;
	}
}
