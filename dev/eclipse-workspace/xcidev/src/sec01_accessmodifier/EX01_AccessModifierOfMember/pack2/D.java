package sec01_accessmodifier.EX01_AccessModifierOfMember.pack2;

import sec01_accessmodifier.EX01_AccessModifierOfMember.pack1.A;

public class D extends A {

	public void print() {
		System.out.print(a + " ");
		System.out.print(b + " ");
//		System.out.print(c + " ");
//		System.out.print(d);
		// 자식클래스는 다른 패키지여도 protected까지 접근 가
		System.out.println();
	}
}
