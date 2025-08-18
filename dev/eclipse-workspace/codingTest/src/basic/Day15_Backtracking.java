package basic;

import java.util.*;

public class Day15_Backtracking {
	
	static int n , m;
	static boolean[] used;
	static int[] path;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); 
		m = sc.nextInt();
		
		used = new boolean[n+1];
		path = new int[m];
		
		dfs(0);
		
	}	
	
	private static void dfs(int depth) {
		if(depth == m) {
			for(int v : path ) {
				System.out.print(v + " ");
			}	
			System.out.println();
			return;
		}
		
		for(int i =1; i <= n; i++ ) {
			if(!used[i]) {
				used[i] = true;
				path[depth] = i;
				dfs(depth + 1);
				used[i]= false;
			}
		}
	}
}
