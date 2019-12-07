package com.projects.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.products.controller.ProductsController;
import com.products.model.Product;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 6135969864279126440L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ProductsController productsController = new ProductsController();
		List<Product> allProducts = productsController.getAllProducts();
		PrintWriter out =  response.getWriter();
		
		String json = new Gson().toJson(allProducts);
		out.print(json);
	}
}
