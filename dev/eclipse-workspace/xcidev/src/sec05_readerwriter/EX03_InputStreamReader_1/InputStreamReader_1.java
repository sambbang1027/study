package sec05_readerwriter.EX03_InputStreamReader_1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class InputStreamReader_1 {
	public static void main(String[] args) {
		
		File inputStreamReader = new File("src/files/InputStreamReader.txt");
		
		try(Reader reader = new FileReader(inputStreamReader)){
			int data;
			while((data = reader.read()) != -1) {
				System.out.print((char)data);
			}
		}catch(IOException e) {}
		
		try(InputStream is = new FileInputStream(inputStreamReader);
				InputStreamReader isr = new InputStreamReader(is, "MS949");){
			int data;
			while((data = isr.read()) != -1) {
				System.out.print((char)data);
			}
			System.out.println("\n"+ isr.getEncoding()); // MS949
		}catch(IOException e) {}
	}
}
