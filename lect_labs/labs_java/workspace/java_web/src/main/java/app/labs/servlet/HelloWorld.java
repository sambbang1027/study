package app.labs.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HelloWorld() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//response.getWriter().append("Served at: ").append(request.getContextPath());
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<h1>Hello World</h1>");
				out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
	}

}
