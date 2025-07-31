package sec03_constructor.EX01_DefaultConstructor;

class A {
	int m ;
	void work() {
		System.out.println(m);
	}
	/*
	 * A() {
	 * 
	 * }
	 * */
}

class B {
	int m;
	void work() {
		System.out.println(m);
	}
	B() {
		
	}
}
class C {
	int m;
	void work() {
		System.out.println(m);
	}
	C(int a){
		m= a;
	}
}

public class DefaultConstructor {

	public static void main(String[] args) {
		
		// 클래스의 객체 생성
		A a = new A();
		B b = new B();
		C c = new C(3);
	
		
		// 메서드 호출
		a.work();
		b.work();
		c.work();
	}
	
}
