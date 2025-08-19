package app.labs.ex03.di05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmpController {
	

	private IEmpService empService;
	@Autowired
	public EmpController(IEmpService empService) {
		this.empService = empService;
	}
	
	public void printInfo() {
		int count = empService.getEmpCount(50);
		System.out.println("사원의 수 : "+ count);
	}

}
