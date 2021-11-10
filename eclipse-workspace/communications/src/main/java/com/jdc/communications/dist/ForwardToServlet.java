package com.jdc.communications.dist;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/forward/dist")
public class ForwardToServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Include Header
		req.getRequestDispatcher("../header").include(req, resp);

		// Title
		resp.getWriter().append("<h1>Forward Demo</h1>");

		// Message
		resp.getWriter().append("<p>Hello from Forward To Servlet!</p>");

		// Include Footer
		getServletContext().getRequestDispatcher("/footer").include(req, resp);
	}
}
