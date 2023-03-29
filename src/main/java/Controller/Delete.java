package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxCursor.Fetch;

import DAO.Userdao;
import DTO.UserInfoPage;
@WebServlet("/delete")
public class Delete extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Userdao userdao = new Userdao();
		UserInfoPage infoPage = userdao.fetch(id);
		
		userdao.delete(infoPage);
		
		
		req.setAttribute("list",userdao.fetchAll());
		res.getWriter().print("<h1> Data deleted Successfully</h1>");
		req.getRequestDispatcher("Home.jsp").include(req, res);
	}
	
}
