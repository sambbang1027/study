package basic;

import java.util.Scanner;

/**
 * n과 s 가 주어질 때
n개 정수로 이어진 수열과
수열의 원소를 다 더한 값이 s가 되는 경우의 수를 찾자
주어지는 수 -> n , s, n개의 정수
5 0
-7 -3 -2 5 8
 * */

public class Day19_Backtracking {
	
	static int n , s;
	static int[] ary;
	static int count = 0;

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); 
		s = sc.nextInt();
		ary = new int[n];
		
		for(int i = 0; i < n; i++) {
			ary[i] = sc.nextInt();
		}
		
		dfs(0 , 0);
		
		System.out.println(count);
	}
	
	private static void dfs(int depth, int sum) {
		
		if(depth == n) {
			return;
		}
		
		if(sum + ary[depth] == s) {
			count++;
		}
		
		dfs(depth + 1, sum+ ary[depth]);
		
		dfs(depth+1, sum);

	}
}
