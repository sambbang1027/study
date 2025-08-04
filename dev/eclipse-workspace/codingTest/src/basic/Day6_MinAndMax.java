package basic;

import java.util.*;
//N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램
// int n ; 
// arry[n];
// for(n){
// arry 에 값넣
//}
// int max;
// int min;
//
// for(array.length개 만큼){
//     if(max < arry[i]){
//         max = arry[i]
//     }
//     if(min > arry[i]){
//         min = arry[i]
//     }
// }
public class Day6_MinAndMax {
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] array = new int[n];
		
		for(int i = 0; i <n; i++) {
			array[i] = sc.nextInt();
		}
		
		int max = array[0];
		int min = array[0];
		
		for(int k = 0; k < array.length; k++) {
			if(max < array[k]) {
				max = array[k];	
			}
			if(min > array[k]) {
				min = array[k];
			}
			
		}
		System.out.println(min + " "+ max);
	}
}
