package app.labs.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/CalcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CalcServlet() {
        super();
            }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String op = request.getParameter("operator");
		
		CalcService calc = new CalcService(num1, num2, op);
		int result = calc.getResult();
		
		// 제어를 calc.jsp에게 넘기겠다는 말
		RequestDispatcher rd = request.getRequestDispatcher("calc.jsp");
		request.setAttribute("result",Integer.toString(result));
		// 제어를 넘길때 result 라는 키값으로 result를 넘기겠다
		rd.forward(request, response); // 넘기기 
		
	}
	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
	}

}
