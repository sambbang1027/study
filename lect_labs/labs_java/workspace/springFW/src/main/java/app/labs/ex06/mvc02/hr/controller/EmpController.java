package app.labs.ex06.mvc02.hr.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.labs.ex06.mvc02.hr.model.Emp;
import app.labs.ex06.mvc02.hr.service.IEmpService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EmpController {
		
		@Autowired
		IEmpService empService;

		@RequestMapping(value = "/hr/count")
		public String empCount(@RequestParam(value = "deptId", required = false, defaultValue = "0")int deptId,  Model model) {
													// deptId가 없을 수도 있기때문에 required = false 임 디폴트값은 0
			int cnt = 0;
			if(deptId == 0) {
				cnt = empService.getEmpCount();
			}else {
				cnt = empService.getEmpCount(deptId);
			}

			model.addAttribute("count", cnt);
			return "hr/count" ;
		}
		
		@RequestMapping(value = "/hr/list")
		public String getAllEmp(Model model ) {
			
			List<Emp> list =	empService.getEmpList();
			model.addAttribute("emplist", list);
			
			return "hr/list";
		}
		
		@RequestMapping(value = "/hr/{employeeId}")
		public String getEmpInfo(Model model , @PathVariable int employeeId) {
			
			Emp info =  empService.getEmpInfo(employeeId);
		
			model.addAttribute("emp",info);
			
			return "hr/view";
		}
		
		
		@RequestMapping(value = "/hr/insert", method = RequestMethod.GET  )
		public String insertEmp(Model model) {
			model.addAttribute("deptList", empService.getAllDeptId());
			model.addAttribute("jobList", empService.getAllJobId());
			model.addAttribute("managerList", empService.getAllManagerId());
			
			return "hr/insertForm";
		}
		
		
		@RequestMapping(value = "/hr/insert", method = RequestMethod.POST  )
		public String insertEmp(Emp emp , RedirectAttributes redirectAttributes) { // vo와 property명이 일치하면 자동 매핑된다 
			
			try {
				empService.insertEmp(emp);	
				redirectAttributes.addFlashAttribute("message", emp.getEmployeeId()+"번 사원정보가 등록되었습니다."); 
				// 한 번 쓰면 사라진다(일회성 메세지 보낼때 )
				
				
			}catch (RuntimeException e) {
				redirectAttributes.addFlashAttribute("message", e.getMessage()); 
				// 한 번 쓰면 사라진다(일회성 메세지 보낼때 )
			}
			return "redirect:/hr/list";  // model은 url로 보낼 수 없다. 따라서 redirectAttribute로 데이터를 전달한다 
		}
		
		@RequestMapping(value = "/hr/update", method = RequestMethod.GET  )
		public String updateForm(Model model , int empid) { 
			// RequestParam은 매개변수명과 param명이 동일하다면 꼭 어노테이션 안써도됨 
			
			model.addAttribute("emp", empService.getEmpInfo(empid));
			
			model.addAttribute("deptList", empService.getAllDeptId());
			model.addAttribute("jobList", empService.getAllJobId());
			model.addAttribute("managerList", empService.getAllManagerId());
			
			return "hr/updateForm";
		}
		
		@RequestMapping(value = "/hr/update", method = RequestMethod.POST  )
		public String updateEmp(Emp emp , RedirectAttributes redirectAttributes) { 
			try {
				empService.updateEmp(emp);	
				redirectAttributes.addFlashAttribute("message", emp.getEmployeeId()+"번 사원정보가 수정되었습니다.");
				
			}catch (RuntimeException e) {
				redirectAttributes.addFlashAttribute("message", e.getMessage()); 
			}
			return "redirect:/hr/list"; 
		}

		@RequestMapping(value = "/hr/delete", method = RequestMethod.GET  )
		public String delete(Model model , int empid) { 
			
			model.addAttribute("emp", empService.getEmpInfo(empid));
		
			return "hr/deleteForm";
		}
		
		
		@RequestMapping(value = "/hr/delete", method = RequestMethod.POST  )
		public String updateEmp(int employeeId , String email, Model model, RedirectAttributes redirectAttributes) { 
			try {
						int cnt = empService.deleteEmp(employeeId, email);	
						
						if(cnt > 0) {
							redirectAttributes.addFlashAttribute("message", employeeId+"번 사원정보가 삭제되었습니다.");
		
						}else {
							model.addAttribute("emp", empService.getEmpInfo(employeeId));
							model.addAttribute("message", "사번 또는 이메일 주소가 다릅니다.");
							return "hr/deleteForm";
						}
				
			}catch (RuntimeException e) {
						redirectAttributes.addFlashAttribute("message", e.getMessage()); 
			}
			return "redirect:/hr/list"; 
		}

		
		//해당 클래스의 exception만 받겠다. 
//		@ExceptionHandler({SQLException.class, RuntimeException.class})
//		public String runtimeException(HttpServletRequest request, Exception ex, Model model) {
//			
//			model.addAttribute("url", request.getRequestURI());
//			model.addAttribute("exception", ex);
//			
//			return "error/runtime";
//		}


		// 데이터를 json 파일로 전달 받기 
		@RequestMapping(value = "/hr/json")
		public @ResponseBody List<Emp> getEmpListJson() {
			return empService.getEmpList();  // json형태로 보낼때 ResponseBody를 넣어줘야한다.
		}
		
		@RequestMapping(value = "/hr/json/{employeeId}")
		public @ResponseBody Emp getEmpInfoJson( @PathVariable int employeeId) {
			
			Emp info =  empService.getEmpInfo(employeeId);
		
			
			return info;
		}
		
}
