package oop6.multi;
class Important {
	
}
public class ThreadExam2 extends Important implements Runnable{
	public static void main(String[] args) {
		Runnable  t = new ThreadExam2();
		Thread t2 = new Thread(t);
		t2.start();
		
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

	public void run() {
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
