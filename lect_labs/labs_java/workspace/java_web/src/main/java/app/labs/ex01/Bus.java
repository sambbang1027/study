package app.labs.ex01;

public class Bus implements Transportation {
	
	private int busNumber;
	private int passengerCount;
	private int money;
	
	
	public Bus(int busNumber) {
		this.busNumber = busNumber;
		this.passengerCount = 0;
		this.money = 0;
	}
	

	public void getIn(Student pass) {
		++this.passengerCount;
		this.money += 900;  // 나중에 생성자 초기화 하기
		pass.withdraw(900);
		
		
		//개발용 로그 
		System.out.println(this.toString());
		System.out.println(pass.toString());
	}
	
	@Override
	public void getIn(PassengerImpl pass) {
		++this.passengerCount;
		this.money += 1000;  // 나중에 생성자 초기화 하기
		pass.withdraw(1000);
		
		
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
		return "Bus [busNumber=" + busNumber + ", passengerCount=" + passengerCount + ", money=" + money + "]";
	}
	
	

}
