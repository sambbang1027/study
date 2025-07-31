package sec02_abstractmodifier.EX02_AbstractModifier_2;

abstract class Animal{ 
	abstract void cry();
	// 추상 메서드를 1개 이상 포함하므로 추상 클래스 정의
}
class Cat extends Animal {
	void cry() {
		System.out.println("야옹");
	}
}
class Dog extends Animal {
	void cry() {
		System.out.println("멍멍");
	}
}


public class AbstractModifier_2 {
	public static void main(String[] args) {
		// create an instance
		Animal animal1 = new Cat();
		Animal animal2 = new Dog();
		
		// invoke a  method 
		animal1.cry();
		animal2.cry();
	}
}
