package app.labs.ex01;

public class TakeTransTest {

	public static void main(String[] args) {
		PassengerImpl pass1 = new Adult(1, "승객1", 10000);
		PassengerImpl pass2 = new Adult(2, "승객2", 15000);
		Student stud1 = new Student(1, "학생1", 15000);
		
		Transportation bus100 = new Bus(100);
		Transportation bus200 = new Bus(200);
		
		Transportation subway1 = new Subway(1);

		bus100.getIn(pass1);
		bus100.getIn(pass2);

		bus100.getOut(pass1);
		bus100.getOut(pass2);
		
		bus200.getIn(pass1);
		bus200.getOut(pass1);

		subway1.getIn(pass1);
		subway1.getOut(pass1);
		
		bus100.getIn(stud1);
		bus100.getOut(stud1);
	}
}
