package operation;

import java.util.Scanner;

public class OpTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("a : "); int a = sc.nextInt();
		System.out.print("b : "); int b = sc.nextInt();
		
		
		System.out.println(a+ "+" +b + "=" + (a+b));
		System.out.println(a+ "-" +b + "=" + (a-b));
		System.out.println(a+ "*" +b + "=" + (a*b));
		System.out.println(a+ "/" +b + "=" + (a/b)); // 정수와 정수의 연산 결과는 정
		System.out.println(a+ "/" +b + "=" + (a/(double)b)); // 실수의 값을 원하면 연산 전 형변환 
		System.out.println(a+ "%" +b + "=" + (a%b));
		sc.close();
		System.out.println("종료");
	}
}
