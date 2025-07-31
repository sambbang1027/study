package method;

import java.util.Scanner;

public class ScissorGame {
	public static void main(String[] args) {
//		String[] caption = {"가위", "바위", "보"};
//		try (Scanner sc = new Scanner(System.in)){
//			
//			System.out.println("가위는 1, 바위는 2, 보는 3을 입력 > ");
//			int you = sc.nextInt();
//			int com = (int)(Math.random() * 3 + 1);
//			
//			System.out.println("You : " + caption[you-1]);
//			System.out.println("Com : " + caption[com-1]);
//		}

		
		try (Scanner sc = new Scanner(System.in)){
			
			System.out.println("가위는 1, 바위는 2, 보는 3을 입력 > ");
			int you = sc.nextInt();
			int com = (int)(Math.random() * 3 + 1);
			
//			System.out.println("You : " + caption(you));
//			System.out.println("Com : " + caption(com-1));
			
			
			System.out.print("You : ");printCaption(you);
			System.out.print("Com : ");printCaption(com);
		}
	}

	private static void printCaption(int val) {
		switch(val) {
		case 1 : System.out.println("가위"); break;
		case 2 : System.out.println("바위"); break;
		case 3 : System.out.println("보"); break;
		default : System.out.println("에러"); break;
		}		
	}

	private static String caption(int val) {
			switch(val) {
			case 1 : return"가위";
			case 2 : return "바위";
			case 3 : return "보";
			default : return "에러";
			}
			// 더 모듈화를 시키고 싶을 때는 바로 출력보다는 값을 전달해서 
			//사용하는 사람이 출력하는 방법을 정하는게 코드의 재사용성이 더 높아짐 
	}
}