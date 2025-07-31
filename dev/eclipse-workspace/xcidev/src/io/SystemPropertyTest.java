package io;

public class SystemPropertyTest {
	public static void main(String[] args) {
		for(Object okey: System.getProperties().keySet()) {
			String key = (String) okey;
			System.out.println(key + ":"+System.getProperty(key));
		}
	}
}
