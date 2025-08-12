package app.labs.ex01;

public class Student extends PassengerImpl {
//	private int regNumber; // 불변형 성격을 가짐
//	private String name; // 불변형 
//	private int money; // 가변형  
//	
	//한 번 셋팅한 값을 변경 하지 않고 싶다면 생성자에서만 초기화한다. 
	// 중간에 값을 외부에서 변화시키려면 getter , setter 를 사용한다. 
	// 따라서, 이름과 주민번호는 한번 셋팅하면 변경되지 않는다 
	public Student(int regNumber, String name, int money) {
		super(regNumber, name, money );
//		this.regNumber = regNumber;
//		this.name = name;
//		this.money = money;
	}


//	@Override
//	public void withdraw(int amount) {
//		this.money -= amount;
//	}
//
//	@Override
//	public void deposit(int amount) {
//		this.money += amount;
//	}




//	@Override
//	public String toString() {
//		return "Student [regNumber=" + regNumber + ", name=" + name + ", money=" + money + "]";
//	}

}
