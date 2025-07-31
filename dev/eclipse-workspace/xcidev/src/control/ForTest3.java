package control;

public class ForTest3 {
	public static void main(String[] args) {
		int sum =0;
		//1 ~ 1000까지 3의 배수의 합계 
		for(int i=1; i<=1000; i++) {
			if(i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
		
		for (int i=3; i<=1000; i+=3) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println("종료");
	}

}
