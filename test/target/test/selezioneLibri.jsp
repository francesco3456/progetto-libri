<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.bean.LibroBean"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	List<LibroBean> autori = (List<LibroBean>) request.getAttribute("autori");
	%>

    <form action="LibroByAutore" method="get">
        <h2>Scegli un autore:</h2>
        <select id="autore" name="author" onchange="this.form.submit()">
            <%
            for (LibroBean libro : autori) {
            %>
            <option value="<%=libro.getAutoreLibro()%>">
                <%=libro.getAutoreLibro()%>
            </option>
            <%
            }
            %>
        </select>
    </form>

</body>
</html>