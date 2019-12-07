package com.projects.view;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.http.RequestEntity;

import com.products.controller.ObjectsSaver;
import com.products.model.SystemUser;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 5763416882307931764L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Enumeration<String> parameterNames = request.getParameterNames();
		ObjectsSaver objectSaver = new ObjectsSaver();
		SystemUser newSystemUser = objectSaver.createSystemUser(parameterNames, request);
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();
		
		boolean successOnRegisterUser = objectSaver.persistSystemUser(newSystemUser);
		json.put("success", successOnRegisterUser);
		
		out.print(json.toString());
	}
}
