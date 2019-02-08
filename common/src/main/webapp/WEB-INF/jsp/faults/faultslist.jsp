<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <title>Faults list</title>
</head>
<body>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<a href="FrontController?command=TEST_COMMAND">
    <p style="text-align: center">
        <button>
            View faults
        </button>
    </p>
</a>
<div align="center">
    Faults list
</div>
<table class="table">
    <c:forEach items="${testList}" var="fault">
        <tr>
            <td>
                <p><c:out value="${fault.fault_id}"/></p>
            </td>
            <td>
                <p><c:out value="${fault.sectorFault_id}"/></p>
            </td>
            <td>
                <p><c:out value="${fault.fault_type}"/></p>
            </td>
            <td>
                <p><c:out value="${fault.date_in}"/></p>
            </td>
            <td>
                <p><c:out value="${fault.finish_date}"/></p>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>