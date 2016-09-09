package com.tz.scriplet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.scriplet.bean.UserBean;
import com.tz.scriplet.service.UserService;

/**
 * Servlet implementation class FromController
 */

@WebServlet("/FromController")
public class FromController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service;

	/**
	 * Default constructor.
	 */
	public FromController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		/*
		 * PrintWriter out = response.getWriter(); out.println("<html>");
		 * out.println("Nombre usuario :"+name);
		 * out.println("Password :"+password); out.println("</html>");
		 */
		UserBean user = new UserBean();
		user.setName(name);
		user.setPassword(password);
		service = new UserService();
		if (service.validarUsuario(user)) {
			request.getRequestDispatcher("formHandler.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("form.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * String name = request.getParameter("name"); String password =
		 * request.getParameter("password"); PrintWriter out =
		 * response.getWriter(); out.println("<html>");
		 * out.println("Nombre usuario :"+name);
		 * out.println("Password :"+password); out.println("</html>");
		 */
		request.getRequestDispatcher("formHandler.jsp").forward(request, response);
	}

}
