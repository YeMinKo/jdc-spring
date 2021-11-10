package com.jdc.communications;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/include")
public class IncludeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Include Message (Relative Path) from ServletRequest
		var header = req.getRequestDispatcher("./header");
		header.include(req, resp);

		// Title
		resp.getWriter().append("<h1>Include Demo</h1>");

		// Include Message (Named Dispatcher) from ServletContext
		var context = getServletContext();
		var message = context.getNamedDispatcher("IncludeMessage"); // named dispatcher
		message.include(req, resp); // include via named dispatcher

		// Own Message
		resp.getWriter().append("<p>Hello from owner Servlet</p>");

		// Include Message (Absolute Path) from ServletContext
		var footer = context.getRequestDispatcher("/footer");
		footer.include(req, resp);

	}
}
