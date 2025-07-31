package sec05_threadstates.EX05_BlockedState;

class MyBlockTest {
	MyClass mc = new MyClass();
	
	Thread t1 = new Thread("thread1") {
		public void run() {
			mc.syncMethod();
		}
	};
	Thread t2 = new Thread("thread2") {
		public void run() {
			mc.syncMethod();
		}
	};
	Thread t3 = new Thread("thread3") {
		public void run() {
			mc.syncMethod();
		}
	};
	
	void startAll() {
		t1.start();
		t2.start();
		t3.start();
		
	}
	
	class MyClass{
		synchronized void syncMethod(){
			try {Thread.sleep(100);}catch(InterruptedException e) {}
			System.out.println("====="+ Thread.currentThread().getName()+ "=====");
			System.out.println("thread 1-> "+ t1.getState());
			System.out.println("thread 2-> "+ t2.getState());
			System.out.println("thread 3-> "+ t3.getState());
			for(long i = 0; i < 100000000000000000L; i++) {}
		}
	}
}
public class BlockedState {
	public static void main(String[] args) {
		MyBlockTest mbt = new MyBlockTest();
		mbt.startAll();
	}
}
