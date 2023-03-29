package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Userdao;
import DTO.UserInfoPage;

@WebServlet("/login")
public class LoginPage extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String emph = req.getParameter("emph");
		String password = req.getParameter("pass");
		Userdao dao = new Userdao();
		PrintWriter out = res.getWriter();
		RequestDispatcher rd = req.getRequestDispatcher("Login.html");
		List<UserInfoPage> list=dao.fetchAll();
		
		try {
			long mobile = Long.parseLong(emph);
			UserInfoPage info = dao.fetch(mobile);
			if (info == null) {
				out.print("<h1>Invalid Mobile Number</h1>");
				rd.include(req, res);
			} else {
				if (info.getPassword().equals(password)) {
//					out.print("<h1>Login successfull</h1>");
//					out.print("<table border='1'>");
//					out.print("<tr>");
//					out.print("<th>ID</th>");
//					out.print("<th>Name</th>");
//					out.print("<th>Mobile</th>");
//					out.print("<th>Email</th>");
//					out.print("<th>Password</th>");
//					out.print("<th>Date</th>");
//					out.print("<th>Gender</th>");
//					out.print("<th>Address</th>");
//					out.print("<th>Country</th>");
//					out.print("<th>Skills</th>");
//					out.print("</tr>");
//					
//					for(UserInfoPage userInfoPage : list) {
//						out.print("<tr>");
//						out.print("<th>"+userInfoPage.getId()+"</th>");
//						out.print("<th>"+userInfoPage.getUsername()+"</th>");
//						out.print("<th>"+userInfoPage.getMobile()+"</th>");
//						out.print("<th>"+userInfoPage.getEmail()+"</th>");
//						out.print("<th>"+userInfoPage.getPassword()+"</th>");
//						out.print("<th>"+userInfoPage.getDate()+"</th>");
//						out.print("<th>"+userInfoPage.getGender()+"</th>");
//						out.print("<th>"+userInfoPage.getAddress()+"</th>");
//						out.print("<th>"+userInfoPage.getCountry()+"</th>");
//						out.print("<th>"+Arrays.toString(userInfoPage.getSkills())+"</th>");
//						out.print("</tr>");
//					}
//					
//					out.print("</table>");
					res.getWriter().print("<h1>Login Succesfull</h1>");
					req.setAttribute("list", list);
					req.getRequestDispatcher("Home.jsp").include(req, res);

				} else {
					out.print("<h1>Invalid Password</h1>");
					rd.include(req, res);
				}
			}

		} catch (NumberFormatException e) {
			String email = emph;
			UserInfoPage info = dao.fetch(email);
			if (info == null) {
				out.print("<h1>Invalid email</h1>");
				rd.include(req, res);
			} else {
				if (info.getPassword().equals(password)) {
					
//					
//					out.print("<h1>Login successfull</h1>");
//					out.print("<table border='1'>");
//					out.print("<tr>");
//					out.print("<th>ID</th>");
//					out.print("<th>Name</th>");
//					out.print("<th>Mobile</th>");
//					out.print("<th>Email</th>");
//					out.print("<th>Password</th>");
//					out.print("<th>Date</th>");
//					out.print("<th>Gender</th>");
//					out.print("<th>Address</th>");
//					out.print("<th>Country</th>");
//					out.print("<th>Skills</th>");
//					out.print("</tr>");
//					
//					for(UserInfoPage userInfoPage : list) {
//						out.print("<tr>");
//						out.print("<th>"+userInfoPage.getId()+"</th>");
//						out.print("<th>"+userInfoPage.getUsername()+"</th>");
//						out.print("<th>"+userInfoPage.getMobile()+"</th>");
//						out.print("<th>"+userInfoPage.getEmail()+"</th>");
//						out.print("<th>"+userInfoPage.getPassword()+"</th>");
//						out.print("<th>"+userInfoPage.getDate()+"</th>");
//						out.print("<th>"+userInfoPage.getGender()+"</th>");
//						out.print("<th>"+userInfoPage.getAddress()+"</th>");
//						out.print("<th>"+userInfoPage.getCountry()+"</th>");
//						out.print("<th>"+Arrays.toString(userInfoPage.getSkills())+"</th>");
//						out.print("</tr>");
//					}
//					
//					out.print("</table>");
					
					res.getWriter().print("<h1>Login Succesfull</h1>");
					req.setAttribute("list", list);
					req.getRequestDispatcher("Home.jsp").include(req, res);
					
				} else {
					out.print("<h1>Invalid Password</h1>");
					rd.include(req, res);
				}
			}
		}
	}

}
