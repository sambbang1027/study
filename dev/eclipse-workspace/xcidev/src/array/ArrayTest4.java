package array;

public class ArrayTest4 {

	public static void main(String[] args) {
		// 표  행  열 
		int[][][] score = {
			{	
				{100, 90, 80, 70},
				{90, 80, 70, 60 },
				{80, 70, 60, 50 }
			},	
			{	
				{100, 100, 90, 80},
				{100, 90, 80, 70 },
				{ 90, 80, 70, 60 }
			},	
		};
		System.out.println("국어\t영어\t수학\t철학\t총점\t평균");
	
		for(int sem=0; sem < score.length; sem++) {
			for(int row = 0; row < score[sem].length; row++) {
				int total = 0;
				for(int col = 0; col < score[sem][row].length; col++) {
					System.out.print(score[sem][row][col] + "\t");
					total = total + score[sem][row][col];
				}
				System.out.print(total + "\t" + total/score[sem][row].length);
				System.out.println();
			}
			System.out.println("========================");
			System.out.println();
		}

		System.out.println("종료");
				
	}
}
