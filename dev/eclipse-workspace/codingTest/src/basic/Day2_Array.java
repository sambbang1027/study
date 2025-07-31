package basic;
import java.util.*;


public class Day2_Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("과목 수를 입력해주세요 >>  ");

		int N = sc.nextInt();
		if(N > 1000) {
			System.out.println("과목의 수는 1000이하로 입력해주세요");
			return;
		}
		
		int[] grades = new int[N];
		double sum = 0;
		int M = 0;
		
		for(int i = 0; i<grades.length; i++) {
			System.out.print("점수를 입력해주세요 >>  ");
			grades[i] = sc.nextInt();
			if(grades[i] > M) {
				M = grades[i];
			}
		}
		System.out.println("최댓값 : "+M);
		
		for(int k = 0; k < grades.length; k++) {
			double newNum= (double)grades[k]/M*100;
			sum += newNum;
		}
		System.out.println("변경 점수 평균 : " + sum/N);
	}
}
