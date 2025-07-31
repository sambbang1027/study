package sec02_exceptionhandlingsyntax.EX06.TryWithResouce_2;

class A implements AutoCloseable{
	String resource;
	A(String resource){
		this.resource = resource;
	}

	@Override
	public void close()throws Exception{
		if(resource!=null) {
			resource=null;
			System.out.println("리소스가 해제됐습니다.");
		}
	}
}

public class TryWithResouce_2 {
	public static void main(String[] args) {
		A a1 = null;
		try {
			a1 = new A("특정 파일");
			System.out.println(a1.resource);
		}catch(Exception e) {
			System.out.println("예외 처리");
		}finally {
			// 여기서 리소스 해제가 됨
			if(a1.resource != null) {
				try {
					a1.close();
				}catch(Exception e) {}
			}
		}
		try(A a2 = new A("특정파일 2")){ 
			//try with resource는 반드시 autoCloseable을 implements 해야 사용할 수 있다.
			System.out.println(a2.resource);
			//try 구문이 끝나면 알아서 해지 됨 
		}catch(Exception e) {
			System.out.println("예외 처리");
		}
	}
}
