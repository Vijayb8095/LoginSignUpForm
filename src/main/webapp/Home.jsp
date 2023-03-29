<%@page import="java.util.Arrays"%>
<%@page import="DTO.UserInfoPage"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>UserName</th>
			<th>Mobile</th>
			<th>Email</th>
			<th>Password</th>
			<th>Date</th>
			<th>Gender</th>
			<th>Address</th>
			<th>Country</th>
			<th>Skills</th>
		</tr>

		<% List<UserInfoPage> list =(List<UserInfoPage>)request.getAttribute("list"); 
for(UserInfoPage infoPage:list){%>
		<tr>
			<th><%=infoPage.getId() %></th>
			<th><%=infoPage.getUsername() %></th>
				<th><%=infoPage.getMobile() %></th>
					<th><%=infoPage.getEmail() %></th>
						<th><%=infoPage.getPassword() %></th>
							<th><%=infoPage.getDate() %></th>
								<th><%=infoPage.getGender() %></th>
									<th><%=infoPage.getAddress() %></th>
										<th><%=infoPage.getCountry() %></th>
											<th><%=Arrays.toString(infoPage.getSkills()) %></th>
											<th><a href="Edit.jsp?id=<%=infoPage.getId()%>"> <button>Edit</button></a></th>
											<th><a href="delete?id=<%=infoPage.getId()%>"> <button>Delete</button></a></th>
		</tr>
		<% }%>
 '/'/'



		<tr>
			<th></th>
		</tr>
	</table>
</body>
</html>