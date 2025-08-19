package basic;

import java.util.Scanner;
import java.util.List;

public class Day17_BackTracking_3 {

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
			ary[depth] = i;
			dfs(depth+1);
		}
	}
}
