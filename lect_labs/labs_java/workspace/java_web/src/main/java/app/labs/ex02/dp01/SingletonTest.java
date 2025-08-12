package app.labs.ex02.dp01;

public class SingletonTest {
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		singleton.showCount(); //인스턴스가 생성되고 난 다음에 인스턴스 메서드도 사용 가능하다.
		
		Singleton singleton1 = Singleton.getInstance();
		singleton1.showCount(); 
		
		Singleton singleton2 = Singleton.getInstance();
		singleton2.showCount();
	}
}
