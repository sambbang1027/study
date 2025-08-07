package basic;
import java.util.*;

public class Day9_Fibonacci {
	public static void main(String[] args) {
		
//		문제분석
//		피보나치 수 : 0번과 1번은 무조건 0과 1이며 
//		그 후로는 앞의 두항의 합이다 피보나치 수를 구하는 프로그램을 만들자
//
//		첫째 줄에 n이 주어진다.
//		n은 20보다 작거나 같은 자연수 또는 0이다. 
//		첫째 줄에 n번째 피보나치 수를 출력한다.
//
//		슈도 코드
//		int n ;
//		int[] fibo
//		for ( n ){
//		    if(n =0 ) 값 = 0;
//		    if(n = 1) 값 = 1; 
//
//		    n = n-1 + n-2 
//		}
		
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fibo = new int[n+1];
        
        for(int i =0; i < fibo.length; i++){
            if(i == 0){fibo[0] = 0; continue;}
            if(i == 1){fibo[1] = 1; continue;}
            
            fibo[i] = fibo[i-1]+ fibo[i-2];
        }
        System.out.println(fibo[n]);
	}
}
