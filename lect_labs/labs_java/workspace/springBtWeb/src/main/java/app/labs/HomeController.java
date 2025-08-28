package app.labs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.labs.ex01.TemplateService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("home")
public class HomeController {

	@Autowired
	TemplateService templateService;
	
	@GetMapping(value = "")
	public	String index (Model model) {
				
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			// 자바17 이후는 포맷터 사용을 권장한다 
			
			String today = now.format(formatter);
			model.addAttribute("today", today);
			
			return "home";
		}
	
	@GetMapping("basic")
	public String basic(HttpServletRequest request,  HttpSession session, Model model) {
		
		model.addAttribute("str", "안녕하세용");
		model.addAttribute("msg", "<b>EL Test</b>");
		model.addAttribute("num", 3.14);
		model.addAttribute("list", templateService.getList() );
		model.addAttribute("map", templateService.getMap() );
		model.addAttribute("user", templateService.getUserAccount() );
		
		
		session.setAttribute("msg", "EL Test");
		request.setAttribute("a", 10);
		
		return "basic/basic";
	}
	
}
