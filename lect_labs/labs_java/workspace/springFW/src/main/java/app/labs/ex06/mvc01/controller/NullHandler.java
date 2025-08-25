package app.labs.ex06.mvc01.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NullHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// 넘겨줄 값(뷰에 대한 정보)이 없을 때 null을 반환해주는 핸들러
		return null;
	}

}
