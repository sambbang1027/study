package app.labs.ex06.mvc01.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardInsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(">>>>>>> 게시판 글  작성 <<<<<<<");
		return "redirect:/boardlist.do";
	}

}
