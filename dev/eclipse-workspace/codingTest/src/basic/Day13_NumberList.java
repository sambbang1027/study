package basic;

import java.util.*;

public class Day13_NumberList {
	public static void main(String[] args) {
		
//		수열이 존재한다. 
//		이 수열은 1, 2 , 2 , 3, 3, 3 , 4, 4, 4, 4, 5, 5, 5, 5, 5,... 
//		이런 규칙을 가진 수열이다.
//		그리고 수열의 구간을 나타내는 숫자 두개를 입력받는다.
//		이때 이 구간에 존재하는 숫자들의 합을 구하자 ex ) 3 , 7 -> 합 15 ( 2, 3, 3, 3, 4)
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <= b; i++) {
			for(int k = 0; k < i; k++) {
				list.add(i);
			}
		}
		System.out.println(list);

		int sum = 0;
		for(int i = a; i <= b; i++ ) {
			sum += list.get(i-1);
		}
		
		System.out.println(sum);
	}
}
