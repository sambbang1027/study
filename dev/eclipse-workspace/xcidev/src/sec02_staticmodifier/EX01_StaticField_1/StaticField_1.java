package sec02_staticmodifier.EX01_StaticField_1;

class A{
	int m = 3;
	static int n = 5;
}

public class StaticField_1 {
	public static void main(String[] args) {
		A a1 = new A();
		System.out.println(a1.m);
		
		System.out.println(A.n);
		// 객체 생성 없이 클래스명으로 활용 가능
		
		A a2 = new A();
		System.out.println(a2.n);
		// 객체 생성 후 활용 (권장 x)
	}
	
}
