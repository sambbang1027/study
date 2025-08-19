package basic;

import java.util.*;

public class Day16_BackTracking_2 {
	
	static int n, m;
	static boolean[] used;
	static int[] ary;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); 
		m = sc.nextInt();
		used = new boolean[n+1];
		ary = new int[m];
		
		dfs(0);
	}
	
	private static void dfs(int depth) {
		System.out.println("dfs 시작" + depth );

		if(depth == m) {
			for(int value : ary) {
				System.out.print(value + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			System.out.println("dfs-> for문시작" +i );
			if(!used[i]) {
				if(depth > 0 && i < ary[depth-1]) {
					System.out.println("i < depth : " +i +" < "+ depth );
					continue;
				}
				used[i] = true;
				ary[depth] = i; 
				dfs(depth+1);
				System.out.println("used[i] 초기화 " + i);
				used[i] = false;
			}
		}
	}
}
