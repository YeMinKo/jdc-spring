package com.jdc.communications.includes;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HTML Header
		var out = resp.getWriter();
		out.append("<!DOCTYPE html>");
		out.append("<html>");
		out.append("<head>");
		out.append("<meta charset='ISO-8859-1'>");
		out.append("<title>Communication</title>");
		out.append("</head>");
		out.append("<body>");
	}
}
