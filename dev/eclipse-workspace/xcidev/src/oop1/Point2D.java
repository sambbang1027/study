package oop1;

import lombok.Getter;

@Getter
public class Point2D {
	
		private int x;
		private int y;
		

		public void setX(int x) {
			this.x = x;
		}
		public void setY(int y) {
			this.y = y;
		}
		public void print() {
			System.out.println("x = " + this.getX());
			System.out.println("y = " + this.getY());
		}

	
}
