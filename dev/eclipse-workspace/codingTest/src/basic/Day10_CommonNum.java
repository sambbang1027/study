package basic;

import java.util.*;

public class Day10_CommonNum {
	public static void main(String[] args) {
		
//		두 개의 자연수를 입력 받아 최대 공약수와 최소 공배수를 출력하자
//
//		최대 공약수 : 두 수의 공통된 약수(나누어 떨어지게 하는 수) 중
//		가장 큰 수
//		최소 공배수 : 두 수의 공통된 배수 중 가장 작은 수

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		// 최대 공약수 
		
		int small= Math.min(n, m);
		int divisor =1;
		System.out.println("small :   "+small);
		for(int i = small; i > 1; i--) {
			if(m % i == 0 && n % i ==0) {
				divisor = i;
				break;
			}
		}
		System.out.println("divisior :   " + divisor);
		// 최소공배수 
		int multiple = (m * n) / divisor;
		System.out.println("multiple :    "+ multiple);
	}
}
