package com.projects.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.products.controller.LoginController;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -744760641129421208L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginController loginController = new LoginController();
		boolean userExists = loginController.userExists(username, password);

		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();

		json.put("success", userExists);
		out.print(json.toString());
	}
}
