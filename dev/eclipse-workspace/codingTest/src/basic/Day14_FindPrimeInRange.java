package basic;

import java.util.*;

public class Day14_FindPrimeInRange {
	public static void main(String[] args) {
//		숫자 a 와 b가 주어진다 이는 숫자 범위가 된다.
//		a 와 b 사이의 숫자들 중 소수를 찾는다. 
//		범위 내의 모든 소수들의 합과 최솟값을 구하자
//		단, 범위 내에 소수가 없다면 -1 을 출력한다


		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int sum = 0;
		int min = 0;
			
		for(int i = a; i <= b; i++) {
			boolean isPrime = true;
			if(i == 1) {
				isPrime = false;
			}
			System.out.println("디버깅 : i -> " + i);
			for(int k = 2; k < i; k++) {
				if(i % k == 0) {
					isPrime = false;
					break;
				}
			}
			System.out.println("디버깅 : isPrime -> " + isPrime);
			if(isPrime) {
				sum += i; 
				if(min == 0) {
					min = i;
				}
				if (min > i) {
					min = i;
				}
				System.out.println("디버깅 :sum -> " + sum);
				System.out.println("디버깅 : min -> " + min);
			}
		}
	
		
		if( sum == 0) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
			System.out.println(min);
		}
		
		
	}
}
