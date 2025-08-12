package app.labs.ex01;

public interface Transportation {
	void getIn(PassengerImpl pass);
	void getOut(PassengerImpl pass);
	void getIn(Student pass); // 이렇게 선언해서 하는거 맞나욤?
		
}
