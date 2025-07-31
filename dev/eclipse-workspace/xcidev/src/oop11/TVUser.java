package oop11;

import java.io.FileInputStream;
import java.util.Properties;

public class TVUser {
	public static void main(String[] args) throws Exception {
		//TVUser가 삼성TV에 의존적이지 않게 하는 방법
		
//		Properties prop = new Properties();
//		prop.load(new FileInputStream("src/oop11/product.properties"));
//		String tvName = prop.getProperty("tv");
//		Class tvClass = Class.forName(tvName);
//		
//		TV tv = (TV) tvClass.getConstructor().newInstance(); // new SamsungTV() 대체하는 방
//
//		// 의존관계를 줄이는 방법
//		String speakerName = prop.getProperty("speaker");
//		Class speakerClass = Class.forName(speakerName);
//		Speaker speaker = (Speaker) speakerClass.getConstructor().newInstance();
//		tv.setSpeaker(speaker);
//		TV tv = new LgTV();
		
		TV tv = TVFactory.getTV(); // new LgTV();
		tv.setSpeaker(SpeakerFactory.getSpeaker()); // new HarmanSpeaker();
		
		tv.powerOn();
		tv.channelUp();
		tv.channelDown();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
	}
}
