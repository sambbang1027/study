package operation1;

public class OpTest5 {
	public static void main(String[] args) {
		int a = 10; 
		int b = a++;
		// 1. b=a 2. a= a+1 의 순서가 됨
		System.out.println(a+ "," + b);
		
	}
}
