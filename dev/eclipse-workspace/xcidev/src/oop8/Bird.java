package oop8;

public class Bird extends Animal{
	
	void wings(String w) {}
	
	@Override
	public String toString() {
		return "Bird 입니다.";
	}
	
	public String wings() {
		return "날갯짓을 합니다.";
	}
}
