package method;

public class MethodTest1 {
	public static void main(String[] args) {
		print("신해철");
		print("서태지");
		print();
		//method overload (메소드 중복정의) 같은 메소드의 명을 정의한것 
	}
	private static void print() {
		System.out.println("안녕하세요");
	}

	private static void print(String name) {
		System.out.println("*--------*");
		System.out.println("| "+ name +" |");
		System.out.println("*--------*");
	}
}
