package com.jdc.hello;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", value = {"/hello", "/my-hello"}, loadOnStartup = 1, initParams = {
		@WebInitParam(name = "defaultSize", value = "100"), @WebInitParam(name = "waitTime", value = "3"),
		@WebInitParam(name = "timeUnit", value = "Seconds") })
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		log("Hello servlet is initialized!");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log("Do Get method is working!");

		log("Servlet Name is : " + getServletName());
		log("Servlet Info is : " + getServletInfo());

		// Init Parameters
		var initParams = getInitParameterNames();

		while (initParams.hasMoreElements()) {
			var name = initParams.nextElement();
			log(String.format("%16s : %s%n", name, getInitParameter(name)));
		}

		// Get Request Parameters
		log(String.format("Name : %s", req.getParameter("name")));
		log(String.format("Course : %s", req.getParameter("course")));

		resp.getWriter().append("<h1>").append("Hello from Servlet").append("</h1>").flush();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get Request Parameters
		log(String.format("Name : %s", req.getParameter("name")));
		log(String.format("Course : %s", req.getParameter("course")));
		
		var out = resp.getWriter();
		out.append("<!DOCTYPE html>");
		out.append("<html>");
		out.append("<head>");
		out.append("<meta charset='ISO-8859-1'>");
		out.append("<title>Hello</title>");
		out.append("</head>");
		out.append("<body>");
		
		out.append("<h1>").append("Building Response").append("</h1");
		out.append("<h3>").append("Your Response is").append("</h3>");
		out.append("<p>").append("Name: ").append(req.getParameter("name")).append("</p>");
		out.append("<p>").append("Course: ").append(req.getParameter("course")).append("</p>");
		
		
		out.append("</body>");
		out.append("</html>");
	}

	@Override
	public void destroy() {
		log("Servlet is destroying!");
	}

}
