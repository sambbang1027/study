package basic;

import java.util.Scanner;

public class day3_arraySum {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int N  = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		int[] sumArr = new int[N];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			if(i == 0) {
				sumArr[0] = arr[0];
			}else {
				sumArr[i] = sumArr[i-1]+ arr[i];
			}
		}
		
		int sum = 0;
		for(int k = 0; k < M; k++) {
			int I = sc.nextInt();
			int J = sc.nextInt();
			if(I == 1) {
				sum = sumArr[J-1];
			}else {
				sum = sumArr[J-1] - sumArr[I-2];

			}
			System.out.println(sum);
		}
	}
}
