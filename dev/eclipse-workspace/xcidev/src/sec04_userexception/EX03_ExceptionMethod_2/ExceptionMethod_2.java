package sec04_userexception.EX03_ExceptionMethod_2;

class A{
	void abc() throws NumberFormatException{
		bcd();
	}
	void bcd() throws NumberFormatException{
		cde();
	}
	void cde() throws NumberFormatException{
		int num = Integer.parseInt("10A");
	}
}

public class ExceptionMethod_2 {
	public static void main(String[] args) {
		//1. 객체 생성
		A a = new A();
		// 2. 메서드 호출 + 예외 처리
		try {
			a.abc();
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
