<%@page import="org.nlt.model.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<div class="row">

	<div class="col-md-2">
		<img src="res/images/nlt.png"/>
	</div>
	
	<div class="col-md-7">
		<div class="row">
			<div class="col-md-12"><h2 class="display-4 text-info"><strong>NLT INFOTECH PVT. LTD.</strong></h2></div>
		</div>
		
		<div class="row">
			<div class="col-md-12"><h6 class="display-6 text-primary">Software Development & IT Solutions</h6></div>
		</div>
	</div>
	
	<div class="col-md-3 pt-4">
	
		<%
			Users user=(Users)session.getAttribute("UserLogin");
			if(user!=null)
			{
		%>
				<div class="row">
					<div class="col-md-12">
						<!--Login User: Sham-->
						Login: <%=user.getName() %>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<a href="./logout">Logout</a>
					</div>
				</div>
		<%
			}
		%>
	</div>
</div>