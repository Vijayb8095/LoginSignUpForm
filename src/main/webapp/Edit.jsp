<%@page import="DTO.UserInfoPage"%>
<%@page import="DAO.Userdao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	Userdao userdao = new Userdao();
	UserInfoPage infoPage = userdao.fetch(id);
	%>
	<h1>Enter Your Details here</h1>
	<form action="update" method="post" >
		<table>
			<tr>
				<th>Id:</th>
				<td><input type="text" name="id" value="<%=infoPage.getId()%>"
					readonly="readonly"></td>
			</tr>
			<tr>
				<th>Name:</th>
				<td><input type="text" name="usnm"
					value="<%=infoPage.getUsername()%>" placeholder="Enter Your Name">
				</td>
			</tr>
			<tr>
				<th>Mobile No:</th>
				<td><input type="text" name="mob"
					value="<%=infoPage.getMobile()%>"
					placeholder="Enter Your Mobile No"></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><input type="text" name="ema"
					value="<%=infoPage.getEmail()%>" placeholder="Enter Your Email ID"
					required="required"></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="text" name="pass"
					value="<%=infoPage.getPassword()%>"
					placeholder="Enter Your Password"></td>
			</tr>
			<tr>
				<th>Date Of Birth:</th>
				<td><input type="date" name="dob"
					value="<%=infoPage.getDate()%>" placeholder="Enter Your DOB">
				</td>
			</tr>
			<tr>
				<th>Gender:</th>
				<%
				if (infoPage.getGender().equals("Male")) {
				%>
				<td><input type="radio" name="gen" checked="checked"
					value="Male">Male <input type="radio" name="gen"
					value="Female">Female</td>
				<%
				} else {
				%>
				<td><input type="radio" name="gen" value="Male">Male <input
					type="radio" name="gen" checked="checked" value="Female">Female
				</td>
				<%
				}
				%>

			</tr>

			<tr>
				<th>Address:</th>
				<td><textarea rows="5" cols="30" name="add"
						<%=infoPage.getAddress()%>></textarea></td>
			</tr>
			<tr>
				<th>Country:</th>
				<td><select name="coun">
						<option>India</option>
						<option>America</option>
						<option>Russia</option>
				</select></td>
			</tr>
			<tr>
				<th>Skills:</th>
				<% String[] Skills=infoPage.getSkills();
					 for(String s : Skills){%>
				<%if(s.equals("Team player")){%>
				<td><input type="checkbox" checked="checked" name="Skills"
					value="Team player">Team Player</td>

				<%} else{%>
				<td><input type="checkbox" name="Skills" value="Team player">Team Player
				</td>

				<%}%>
				<%if(s.equals("Quick Learner")){%>
				<td><input type="checkbox" checked="checked" name="Skills"
					value="Quick Learner">Quick Learner</td>

				<%} else{%>
				<td><input type="checkbox" name="Skills" value="Quick Learner">Quick Learner
				</td>

				<%} %>
				<%if(s.equals("Leadership")){%>
				<td><input type="checkbox" checked="checked" name="Skills"
					value="Leadership">Leadership</td>

				<%} else{%>
				<td><input type="checkbox" name="Skills" value="Leadership">Leadership
				</td>

				<%} %>
		<%	} %>
			</tr>
			<tr>
				<td><button type="reset">Cancel</button></td>
				<td><button type="submit">Update</button></td>
			</tr>
		</table>

	</form>

</body>
</html>