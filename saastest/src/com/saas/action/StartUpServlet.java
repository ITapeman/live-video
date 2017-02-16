package com.saas.action;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class StartUpServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		String path = config.getInitParameter("path");
		ServletContext cxt = config.getServletContext();
		//application
		cxt.setAttribute("path", path);
	}
}
