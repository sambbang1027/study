package sec05_innerinterface.EX02_ButtonAPIExample;

class Button{
	OnClickListener ocl;
	void setOnclickListener (OnClickListener ocl) {
		this.ocl = ocl;
	}
	
	interface OnClickListener {
		public abstract void onClick();
	}
	void onClick() {
		ocl.onClick();
	}
}
public class ButtonAPIExample {
	public static void main(String[] args) {
		
		Button btn1 = new Button();
		btn1.setOnclickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("개발자1 : 음악재생");
			}
		});
		btn1.onClick();
		
		Button btn2 = new Button();
		btn2.setOnclickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("개발자 2 : 네이버 접속");				
			}
		});
		btn2.onClick();
	}
}
