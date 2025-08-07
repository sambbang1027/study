package basic;

import java.util.*;

public class Day11_FindThirdNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int k = 0; k < t; k++) {
			Integer[] ary = new Integer[10];

			for(int i = 0; i < 10; i++) {
				ary[i] = sc.nextInt();
			}
			
			Arrays.sort(ary, Collections.reverseOrder());
			
			System.out.println(ary[2]);
		}
	}
}
