package sec02_typeccasting.EX01_Typecasting_1;

// 클래스의 상속관계
class A {}
class B extends A {}
class C extends B {}
class D extends B {}

public class Typecasting_1 {
	
	public static void main(String[] args) {
		// 업캐스팅 : 캐스팅 구문을 략했을 때 컴파일러가 자동으로 추가
		A ac = (A) new C(); // C - > A upcasting
		B bc = (B) new C(); // C -> B upcasting
		
		B bb = new B();
		A a = (A) bb; // B -> A upcasting
		
		// 다운캐스팅 : 캐스팅할 수 없을 때 (실행할 때 예외 발생)
		A aa = new A();
//		B b = (B) aa;  // A -> B downcasting X
//		C c = (C) aa;  // A -> C downcasting X
		
		A ab = new B();
		B b = (B)ab;  // A -> B downcasting O
		// C c = (C)ab; // A -> C downcasting X
		
		B bd = new D();
		D d = (D) bd;  // B -> D downcasting O
		
		A ad = new D();
		B b1 = (B)ad;  // A -> B downcasting O
		D c1 = (D)ad;  // A -> D downcasting O
		
	}
	
}
