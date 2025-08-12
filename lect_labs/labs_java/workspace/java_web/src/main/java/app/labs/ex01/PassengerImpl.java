package app.labs.ex01;

public abstract class PassengerImpl implements Passenger {

	private int regNumber;
	private String name;
	private int money;
	
	
	// 기본 생성자 무력화 시키기 
	public PassengerImpl(int regNumber , String name) {
		this.regNumber = regNumber;
		this.name = name;
	}
	
	public PassengerImpl(int regNumber, String name, int money) {
		this(regNumber, name);
		this.money = money;
	}

	
	@Override
	public void withdraw(int amount) {
		this.money -= amount;
	}

	@Override
	public void deposit(int amount) {
		this.money += amount;
	}

	
	// 접근 제한이 private 이기 때문에 로깅용으로 toString 두기 
	@Override
	public String toString() {
		return "PassengerImpl [regNumber=" + regNumber + ", name=" + name + ", money=" + money + "]";
	}
	
	

}
