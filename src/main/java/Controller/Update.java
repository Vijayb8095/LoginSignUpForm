package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Userdao;
import DTO.UserInfoPage;
@WebServlet("/update")
public class Update extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

//		String usname = req.getParameter("usnm");
//		long mobno = Long.parseLong(req.getParameter("mob"));
//		String email = req.getParameter("ema");
//		String pass = req.getParameter("pass");
		Date date = Date.valueOf(req.getParameter("dob"));
//		String gender = req.getParameter("gen");
//		String address = req.getParameter("add");
//		String country = req.getParameter("coun");
//		String[] skill = req.getParameterValues("Skills");	

		UserInfoPage infoPage = new UserInfoPage();
		infoPage.setId(Integer.parseInt(req.getParameter("id")));
		infoPage.setUsername(req.getParameter("usnm"));
		infoPage.setMobile(Long.parseLong(req.getParameter("mob")));
		infoPage.setEmail(req.getParameter("ema"));
		infoPage.setPassword(req.getParameter("pass"));
		infoPage.setDate(Date.valueOf(req.getParameter("dob")));
		infoPage.setGender(req.getParameter("gen"));
		infoPage.setCountry(req.getParameter("coun"));
		infoPage.setSkills(req.getParameterValues("Skills"));
		infoPage.setAddress(req.getParameter("add"));

		infoPage.setAge(Period.between(date.toLocalDate(), LocalDate.now()).getYears());

		Userdao userdao = new Userdao();
		userdao.merge(infoPage);
		
		res.getWriter().print("<h1>Account Updated Successfully</h1>");
		req.setAttribute("list",userdao.fetchAll());
		req.getRequestDispatcher("Home.jsp").include(req, res);



	}
}
