package app.labs.ex01;

public class Subway implements Transportation {
	private int lineNumber;
	private int passengerCount;
	private int  money;
	
	//  side effect(부작용) - 예측한 값과 다른 값이 나오는 경우
	//외부에 의해 알고리즘에 벗어나는 값이 나올 수 있기 때문에 passengerCount 와 money 는
	// 알고리즘에 의해 변화될 수 있도록 값을 사용자에게 받지 않고 미리 초기화 한다.
	public Subway(int lineNumber) {
		this.lineNumber = lineNumber;
		//this.passengerCount = passengerCount;
		//this.money = money;
		this.passengerCount = 0;
		this.money =0;
	}
	
	// if 문 말고 오버로딩을 적극적으로 사용해라 
	// 오버로딩과 오버라이딩이 동시에 있을 경우 오버로딩 부분은 부모에서 해결해라 
	// 오버로딩은 컴파일 시 적용 , 오버라이딩은 실행 시 적용 
	public void getIn(Student pass) {
		++this.passengerCount;
		this.money += 1400;  // 나중에 생성자 초기화 하기
		pass.withdraw(1400);
		
		
		//개발용 로그 
		System.out.println(this.toString());
		System.out.println(pass.toString());
	}
	
	@Override
	public void getIn(PassengerImpl pass) {
		++this.passengerCount;
		this.money += 1500;  
		pass.withdraw(1500);
		
		
		//개발용 로그 
		System.out.println(this.toString());
		System.out.println(pass.toString());
	}

	@Override
	public void getOut(PassengerImpl pass) {
		--this.passengerCount;
		
		//개발용 로그 
		System.out.println(this.toString());
		System.out.println(pass.toString());
	}


	@Override
	public String toString() {
		return "Subway [lineNumber=" + lineNumber + ", passengerCount=" + passengerCount + ", money=" + money + "]";
	}

}
