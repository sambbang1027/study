package basic;

import java.util.Scanner;

//자연수 n 과 m이 주어졌을 때 1 부터 n까지 만들 수 있는 m 개의 수열을 구하자 
//단, 같은 수는 중복될 수 있고 비내림차순 이어야 한다. 
//이말은 앞항이 뒤항보다 작거나 같아야한다.


public class Day18_Backtracking_4 {
	static int n, m;
	static int[] ary;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		ary = new int[m];
		
		dfs(0);
		System.out.print(sb.toString());
	
	}
	
	private static void dfs(int depth) {
		
		if(depth == m) {
			for(int value : ary) {
				sb.append(value + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			if(depth > 0 && ary[depth-1] >i) {				
				continue;
			}
			ary[depth] = i;
			dfs(depth+1);
		}
		
	}
}
