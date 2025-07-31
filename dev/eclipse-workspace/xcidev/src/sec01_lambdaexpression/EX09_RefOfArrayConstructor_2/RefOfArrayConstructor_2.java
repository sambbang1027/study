package sec01_lambdaexpression.EX09_RefOfArrayConstructor_2;

interface A {
	B abc(int k);
}
class B {
	B(){
		System.out.println("첫 번째 생성자");
	}
	B(int k){
		System.out.println("두 번째 생성자");
	}
}

public class RefOfArrayConstructor_2 {
	public static void main(String[] args) {
		//1. anonymous inner class
		A a1 = new A() {
			@Override
			public B abc(int k) {
				return new B(3);
			}
		};
		// 2. lambda
		A a2 = (int k)-> new B(3);
		
		// 3. class constructor reference
		A a3 = B::new;
		
		a1.abc(3);
		a2.abc(3);
		a3.abc(3);
	}
}
