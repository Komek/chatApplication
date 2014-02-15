package backend.handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backend.controllers.LoginController;

@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServ() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String value;
		PrintWriter writer = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean ret = login(username, password);

		if (ret) {
			value = "True";
		} else {
			value = "false";
		}
		writer.print("<html><body>Return: " + value + "</body></html>"); // Fwrd
																			// to
																			// profile
																			// or
																			// retry
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		writer.print("<html><body>Return: " + email + "</body></html>");
	}

	private boolean login(String username, String password) {
		AccountDTO account = new AccountDTO();
		account.username = username;
		account.password = password;
		LoginController lc = new LoginController();
		return lc.checkCredentials(account);
	}

}
