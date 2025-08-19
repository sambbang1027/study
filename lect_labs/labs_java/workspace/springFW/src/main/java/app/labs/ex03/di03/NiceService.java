package app.labs.ex03.di03;

import org.springframework.stereotype.Service;

@Service
public class NiceService implements IHelloService {

	@Override
	public String sayHello(String name) {
		
		System.out.println("NiceService_sayHello() 메서드 실행" );
		String message = "Nice~~Hello~~"+name;		
		return message;

	}

}
