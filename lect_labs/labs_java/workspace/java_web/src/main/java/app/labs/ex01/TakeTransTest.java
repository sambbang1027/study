package app.labs.ex01;

public class TakeTransTest {

	public static void main(String[] args) {
		Passenger pass1 = new PassengerImpl(1, "승객1", 10000);
		Passenger pass2 = new PassengerImpl(2, "승객2", 15000);
		
		Transportation bus100 = new Bus(100);
		Transportation bus200 = new Bus(200);

		bus100.getIn(pass1);
		bus100.getIn(pass2);

		bus100.getOut(pass1);
		bus100.getOut(pass2);
		
		bus200.getIn(pass1);
		bus200.getOut(pass1);

	}
}
