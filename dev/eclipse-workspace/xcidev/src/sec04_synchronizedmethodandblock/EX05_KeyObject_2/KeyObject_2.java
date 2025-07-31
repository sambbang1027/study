package sec04_synchronizedmethodandblock.EX05_KeyObject_2;

class Mydata{
	
	synchronized void abc() {
		for(int i =0; i<3; i++) {
			System.out.println(i +"sec");
			try {Thread.sleep(1000);}catch(InterruptedException e) {}
		}
	}
	synchronized void bcd() {
		for(int i =0; i<3; i++) {
			System.out.println(i +"초");
			try {Thread.sleep(1000);}catch(InterruptedException e) {}
		}
	}
	
	// 위 두개와 다른 열쇠를 사용하기 때문에 
	void cde() {
		synchronized(new Object()) {
			for(int i =0; i<3; i++) {
				System.out.println(i +"번째");
				try {Thread.sleep(1000);}catch(InterruptedException e) {}
			}
		}
	}
}

public class KeyObject_2{
	public static void main(String[] args) {
		
		Mydata myData = new Mydata();
		
		new Thread() {
			public void run() {
				myData.abc();
			};
		}.start();
		new Thread() {
			public void run() {
				myData.bcd();
			};
		}.start();
		new Thread() {
			public void run() {
				myData.cde();
			};
		}.start();
	}
}
