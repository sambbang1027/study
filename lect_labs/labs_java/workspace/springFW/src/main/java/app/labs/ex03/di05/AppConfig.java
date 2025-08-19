package app.labs.ex03.di05;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configurable
@Configuration
@ComponentScan(basePackages = {"app.labs.ex03.di05"})
public class AppConfig {
	
	@Bean
	IEmpService empService(){
		return new EmpService();
	}

}
