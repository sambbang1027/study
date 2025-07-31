package control;

import java.util.Scanner;

public class RspTest {
	public static void main(String[] args) {
		//가위: 1 바위 : 2 보 3 입력해서 컴퓨터랑 가바보 게임
		
		Scanner sc = new Scanner(System.in);
		int user;
		int com;
		int result;
		System.out.println("가위 바위 보 게임을 시작하겠습니다.");
		do {
			System.out.print("가위는 1 바위는 2 보는 3을 입력하세요 > ");
			com = (int)(Math.random()*3 +1);
			user = sc.nextInt();
			result = user - com ;
			
			System.out.printf("컴퓨터 : %d , 당신 : %d \n", com,user);

			if(result == 0) {
				System.out.println("같은 값이 나왔습니다");
			}else if(result == 2 || result == -1) {
				System.out.println("안타깝습니다. 졌습니다.");
			}else {
				System.out.println("축하드립니다. 이겼습니다.");
			}
		}while(result != 1 && result != -2); System.out.println("종료");
		
		sc.close();
	}

}
