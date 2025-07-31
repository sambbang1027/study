package oop6.multi;

public class ThreadExam {
	public static void main(String[] args) {
		run();
		
		
		for(int i = 0; i <= 5; i++) {
			System.out.println("main : "+ i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("mian : 종료");
	}

	private static void run() {
		for(int i = 0; i <= 5; i++) {
			System.out.println("run : "+ i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("run : 종료");
	}
}
