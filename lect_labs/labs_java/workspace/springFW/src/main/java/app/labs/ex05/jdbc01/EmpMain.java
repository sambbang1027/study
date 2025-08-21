package app.labs.ex05.jdbc01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext context 
				= new  GenericXmlApplicationContext("classpath:config/jdbc01/application-config.xml");
		
		IEmpService empService = context.getBean("empService", IEmpService.class);
		
		System.out.println(">> 사원수 조회 << ");
		System.out.println(empService.getEmpCount());
		System.out.println(empService.getEmpCount(50));
		
		System.out.println(">> 103번 사원 조회 << ");
		System.out.println(empService.getEmpInfo(103));
		
		System.out.println(">> 전체 사원 조회 << ");
		System.out.println(empService.getEmpList());
		
		/*
		 * System.out.println(">> 신규 사원 등록 << "); EmpVO emp = new EmpVO();
		 * emp.setEmployeeId(500); // 이값을 인트로 가져와서 VO 매핑하겠다
		 * emp.setFirstName("FIRST_NAME"); emp.setLastName("LAST_NAME");
		 * emp.setEmail("EMAIL"); emp.setPhoneNumber("PHONE_NUMBER");
		 * emp.setJobId("IT_PROG"); emp.setSalary(8000); emp.setCommissionPct(0.2);
		 * emp.setManagerId(100); emp.setDepartmentId(10);
		 * 
		 * try { empService.insertEmp(emp); System.out.println("Insert OK "); } catch
		 * (Exception e) { System.out.println(e.getMessage()); }
		 */
		
		/*
		 * System.out.println(">> 500번 사원 조회 << ");
		 * System.out.println(empService.getEmpInfo(500));
		 * 
		 * System.out.println(">> 500번 사원 급여 10% 인상  << "); EmpVO emp500 =
		 * empService.getEmpInfo(500); System.out.println(emp500.getSalary()* 1.1);
		 * emp500.setSalary(emp500.getSalary()*1.1); empService.updateEmp(emp500);
		 * 
		 * System.out.println(">> 500번 사원 급여인상 후 조회 << ");
		 * System.out.println(empService.getEmpInfo(500));
		 */
		
		System.out.println(">> 500번 사원 삭제 << ");
		int cnt =empService.deleteEmp(500, "EMAIL");
		
		System.out.println(cnt + "개의 데이터를 삭제하였습다");
		
		System.out.println(empService.getAllDeptId());
		System.out.println(empService.getAllJobId());
		System.out.println(empService.getAllManagerId());
		
		context.close();
	}

}
