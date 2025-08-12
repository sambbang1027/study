package app.labs.ex02.dp02;

public abstract class RunningRace {
	private void ready() {
		System.out.println("준비");
	}
	
	protected  abstract void run();
	
	private void finish() {
		System.out.println("결승선");
	}
	
	
	// 템플릿 디자인 패턴 template method design pattern
	// 메서드 실행 순서를 지정하고 싶을 때 사용한다 
	// 이렇게 사용하면 ready - run - finish 순으로 작동하고 여기서 run은 추상메서드 이기때문에 
	// 알아서 원하는대로 정의하면 된다.
	public final void race() {
		ready();
		run();
		finish();
	}
}
