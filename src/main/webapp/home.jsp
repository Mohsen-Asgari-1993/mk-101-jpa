<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<h1 style="color: red">This is home page</h1>
<p>hello from ${myName}</p>

<ul>
<%--    <c:forEach items="${names}" var="name">--%>
    <%--        <li>${name}</li>--%>
    <%--    </c:forEach>--%>
</ul>


<jsp:include page="footer.jsp"/>