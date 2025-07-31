package sec04_filterinputoutputstream.EX04_PrintStreamExample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class PrintStreamExample {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//#File 객체 생성
		File outFile1 = new File("src/sec04_filterinputoutputstream/files/PrintStream1.txt");
		File outFile2 = new File("src/sec04_filterinputoutputstream/files/PrintStream2.txt");
		
		//#1. PrintStream(FileOutputStream(File))
		try(OutputStream os1 = new FileOutputStream(outFile1);
			PrintStream ps = new PrintStream(os1);){
			//밑의 내용을 포함하는 파일이 생성된다.
			// 출력 디바이스를 바꿀때만1번 사용 
			ps.println(5.8);
			ps.print(3+ " 안녕 "+ 12345 + "\n");
			ps.printf("%d ", 7).printf("%s %f", "안녕", 5.8);
			ps.println();
		} catch(IOException e) {}
		
		//#2. PrintStream(File)
		try(PrintStream ps = new PrintStream(outFile2);){
			// 1번이랑 같지만 outputStream의 유무 차이이다
			// printstream이 outputstream을 상속하고 있기때문에 안거쳐도 된다. 
			//똑같이 파일이 생성됨, 성능도 차이 없음 그냥 파일 출력할거면 2번 사용
			ps.println(5.8);
			ps.print(3+ " 안녕 "+ 12345 + "\n");
			ps.printf("%d ", 7).printf("%s %f", "안녕", 5.8);
			ps.println();
		} catch(IOException e) {}
		
		//#3. PrintStream ps = System.out
		try(OutputStream os2 = System.out;
			PrintStream ps = new PrintStream(os2)){
			// 콘솔 out 으로 줬기때문에 화면으로 출력된다. 
			ps.println(5.8);
			ps.print(3+ " 안녕 "+ 12345 + "\n");
			ps.printf("%d ", 7).printf("%s %f", "안녕", 5.8);
			ps.println();
		} catch(IOException e) {}
		
		
	}
}