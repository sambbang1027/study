package oop11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProductReader {
	
	// single factory pattern 구조 안에서 설값을 읽기 위한 임을 분리해낸 유틸리티 클래
	private static Properties props = new Properties();
	
	static {
		try {
			props.load(new FileInputStream("src/oop11/product.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key) {
		return props.getProperty(key);
	}
	
}
