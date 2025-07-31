package sec02_createandstartthread.EX02_CreatedAndStartThread_M1C2;


class SMIFileThread extends Thread {
	@Override
	public void run() {
		// 자막 번호 하나~다섯
		String[] strArray = {"하나","둘","셋","넷","다섯"};
		try {Thread.sleep(10);}catch(InterruptedException e) {}
		//자막 번호 출력
		for(int i = 0; i < strArray.length; i++) {
			System.out.println(" - (자막 번호) "+ strArray[i]);
			try {Thread.sleep(200);}catch(InterruptedException e) {}
		}
	}
}

class VideoFileThread extends Thread{
	@Override
	public void run() {
		int[] intArray = {1, 2, 3, 4, 5};
		// 프레임
		for(int i=0; i < intArray.length; i++) {
			System.out.print("(비디오 프레임) "+ intArray[i]);
			try {Thread.sleep(200);}catch(InterruptedException e) {}
		}		

	}
}


public class CreatedAndStartThread_M1C2 {
	public static void main(String[] args) {
		Thread smiFileThread = new SMIFileThread();
		smiFileThread.start();
		
		Thread videoFileThread = new VideoFileThread();
		videoFileThread.start();
	}
}
