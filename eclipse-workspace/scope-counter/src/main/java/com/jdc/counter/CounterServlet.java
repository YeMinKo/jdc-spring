package com.jdc.counter;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/counter")
public class CounterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String COUNTER = "counter";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Request Scope
		Counter c1 = (Counter) req.getAttribute(COUNTER);

		if (c1 == null) {
			c1 = new Counter();
			req.setAttribute(COUNTER, c1);
		}
		c1.countUp();

		// Session Scope
		HttpSession session = req.getSession(true);
		Counter c2 = (Counter) session.getAttribute(COUNTER);

		if (c2 == null) {
			c2 = new Counter();
			session.setAttribute(COUNTER, c2);
		}
		c2.countUp();

		// Application Scope
		ServletContext context = getServletContext();
		Counter c3 = (Counter) context.getAttribute(COUNTER);

		if (c3 == null) {
			c3 = new Counter();
			context.setAttribute(COUNTER, c3);
		}
		c3.countUp();

		// Forward to JSP
		context.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}
