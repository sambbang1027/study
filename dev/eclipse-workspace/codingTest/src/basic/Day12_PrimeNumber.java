package basic;

import java.util.*;

public class Day12_PrimeNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ary = new int[n];
		int count = 0;

		for(int i = 0; i < n; i++) {
			ary[i] = sc.nextInt();
			boolean isPrime = true;
			if(ary[i] == 1) {
				isPrime = false;
			}
			for(int k = 2; k < ary[i]; k++){
				System.out.println("소수 체크"+k);
				if(ary[i] % k == 0) {
					System.out.println("소수아님");
					isPrime = false;
					break; 
				}
				System.out.println("소수 체크 끝"+k);
			}
			System.out.println("소수인가 ?"+isPrime);
			if(isPrime) {
				count++;
			}
			System.out.println("최종 카운트 : "+count);
		}
		
	}
}
