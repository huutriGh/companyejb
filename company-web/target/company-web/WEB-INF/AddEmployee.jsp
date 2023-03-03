<%--
  Created by IntelliJ IDEA.
  User: nguyen huu tri
  Date: 02/03/2023
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Insert Employee</h3>
<form action="<c:url value="/employee"/> " method="post" >

    <p>
        <input name="fullName" type="text" placeholder="Employee Name">
    </p>
    <p>
        <input name="birthday" type="date" placeholder="Birthday">
    </p>
    <p>
        <input name="street" type="text" placeholder="street">
    </p>
    <p>
        <input name="ward" type="text" placeholder="Ward">
    </p>
    <p>
        <input name="district" type="text" placeholder="District">
    </p>
    <p>
        <input name="city" type="text" placeholder="City">
    </p>
    <p>
        <input name="age" type="number" placeholder="Age">
    </p>
    <p>
        <input type="reset" value="Reset">
        <input type="submit" value="ADD" name="action">
    </p>
</form>
</body>
</html>
