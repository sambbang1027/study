package basic;

import java.util.*;

public class Day8_SnowPrincess {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		9명의 난쟁이중 일곱 난쟁이 찾기
//		일곱난쟁이 키의 합은 100이며 각각 다른 키를 가지고 있다.
//		출력할땐 오름차순으로 출력
//		9명의 키를 입력받고 2명을 제외하고 7명의 합이 100이면 진짜 아니면 다시 이렇게 가야하려나
		
		int[] heights = new int[9];
		
		for(int i = 0; i < 9; i ++) {
			heights[i] = sc.nextInt();
			//20 7 23 19 10 15 25 8 13
			// 10 50 45 30 35 1 2 3 4
		}
		
		// 오름차순 
		Arrays.sort(heights);
		System.out.println(heights[0]);
		
	    // 7명 조합 중 합이 100인 조합 찾기
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                int sum = 0;
                // i, j는 제외하고 합 계산
                for (int k = 0; k < 9; k++) {
                    if (k != i && k != j) {
                        sum += heights[k];
                    }
                }
                if (sum == 100) {
                    // 정답 출력
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) {
                            System.out.println(heights[k]);
                        }
                    }
                    return; // 정답 찾았으니까 끝냄
                }
            }
        }
		
	}
}
