package basic;

import java.util.*;

//먼저 n개의 수열을 입력받고, 다음으로 합이 n-1개인 4개의 수열을 입력받는다. 
//두 번째로 입력받는 수열은 차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다.
//
//수열의 수와 연산자들로 만들 수 있는 식의 결과값을 모두 구한다 
//그리고 여기서 최솟값과 최대값을 구하면 된다. 
//단, 연산자 우선 순위를 무시하고 앞에서부터 계산한다. 
//또 나눗셈은 정수 나눗셈으로 몫만 취한다.
//음수를 양수로 나눌 때는, 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼다.
//2
//5 6
//0 0 1 0


public class Day20_Backtracking_6 {
	
	static int n ;
	static int[] ary;
	static int[] calc = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // 수열의 개수 
		ary = new int[n];
		for(int i = 0; i < n; i ++ ) {
			ary[i] = sc.nextInt();
		}
		for(int i = 0; i < 4; i++) { // 연산자 
			calc[i] = sc.nextInt();
		}
		
		dfs(1, ary[0]);
		
		System.out.println("최댓값 "+ max);
		System.out.println("최솟값 " + min);
		
	}
	
	private static void dfs (int depth, int sum) {
		if(depth == ary.length) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			System.out.println("max: "+ max + "min : "+ min);
			return;
		}
		
		for(int i = 0; i < 4; i++) {

			
			if(calc[i] > 0) {
				calc[i]--;
				
				if(i == 0) {
					System.out.println("더하겠습니다");
					dfs(depth+1, sum + ary[depth]);
				}else if(i == 1) {
					System.out.println("빼겠습니다");
					dfs(depth+1, sum - ary[depth]);
				}else if(i == 2) {
					System.out.println("곱합니다");
					dfs(depth+1, sum * ary[depth]);
				}else {
					System.out.println("나눕니다");
					dfs(depth+1, sum / ary[depth]);
				}
				
				calc[i]++;
			}
		}
		
	}
}
