package oop8;

public class AnimalTest {
	public static void main(String[] args) {
		
		//클래스와 클래스 간의 형변환은 
			/* 1. 반드시 extends, implements 관계에서 가능
			 * 2. upcasting은 무조건 가능
			 * 3. downcasting은 원래 인스턴스가 현재 다운캐스팅 하려는 타입 
			 *  또는 서브타입 경우 가능
			 *  4. 현재 참조하는 타입에 정의되었거나 상속받은 멤버에만 접근 가능
			 */
		
		Animal a = new Animal();
		System.out.println(a);

		Animal a2 = new Bird();
		System.out.println(a2);
		//System.out.println(a2.wings());
		
		Animal a3 = new Condor();
		System.out.println(a3);
		
		Bird b = new Condor();
		System.out.println(b);
		
		Bird b1 = (Bird) a2; 
		System.out.println(b1);
		System.out.println(b1.wings());
		// upcasting 을 한 a2를 다시 downcasting 하면 wings 에 접근 가능
		
		Bird b2 = (Bird) a3;
		System.out.println(b2);
		System.out.println(b2.wings());
	
		// downCasting 2단계 가능?
		Bird b3 = new Bird();
		System.out.println(b3);
		
		// Condor c1 = (Condor) b4; 3번 규칙이 적용되지 않음
		Condor c2 = (Condor) b;
		System.out.println(c2);
		System.out.println(c2.attack());
		System.out.println(c2.wings());
		
		
		Condor c3 = (Condor) a3;
		System.out.println(c3);
		// 같은 상속구조이면 2단계든 몇단계든 다운캐스팅이 가능하다 
		
		
		Animal n = new Cat();
		System.out.println(n);
		
		Bird b4 = (Bird) n;
		System.out.println(b4);
		// classCastException 발생 같은 상속 구조에서만 다운캐스팅가능 
		
	}

}
