package app.labs.ex02.dp01;

// 싱글톤 디자인 패턴 - 공용 객체 1개 생성 
// 객체 하나를 static으로 만들어서 모든 객체들이 공용으로 사용할 수 있게 한다.
public class Singleton {
	
	private static Singleton singleton = null;
	private int count = 0;
	
	//생성자 생성 -> private
	private Singleton() {}
	
	
	// 클래스 메서드 - 인스턴스를 확보할 수 있는 메서드 생성 
	// 객체 생성 메서드
	public static Singleton getInstance() {
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
	
	public void showCount() {
		count++;
		System.out.println("count : "+ count);
	}
}
