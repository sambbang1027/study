package enum1;

public class PowerStateTest {
	public static void main(String[] args) {
		PowerState state = PowerState.SUSPEND;
		
		System.out.println("현재 상태 "+ state.name());
		System.out.println("상세 메세지 "+ state.getMessage());
	
		state.printStatus();
	}
}
