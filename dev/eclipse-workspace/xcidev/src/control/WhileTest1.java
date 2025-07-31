package control;

public class WhileTest1 {
	public static void main(String[] args) {
		int n=3;
		int sum = 0;
		while (n<= 1000) {
			sum += n;
			n+=3;
		}
		System.out.println(sum);
		System.out.println("종료");
	}

}
