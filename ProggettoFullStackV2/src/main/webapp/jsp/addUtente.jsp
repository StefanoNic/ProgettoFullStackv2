<%--suppress XmlPathReference --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: stefa
  Date: 09/02/2022
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiungi customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <c:choose>
        <c:when test="!${sessionScope.isAdmin}">
            <c:when test="${utente.id !=  sessionScope.loggedId}"> <c:redirect url="login"/> </c:when>
        </c:when>
    </c:choose>
    <jsp:include page="component/header.jsp"/>
</head>
<body>
<c:url var="url" value="/utentiPost"/>
<div class="bg-white">
    <div class="row bg-dark">
        <div class="col-md-4 col-1"></div>
        <div class="col-md-4 col-10">
            <form:form action="${url}" method="post" modelAttribute="utente">
                <form:input type="hidden" path="id" name="userId" value="${utente.id}"/>
                <form:input type="hidden" path="persona" name="personaId" value="${personaId}"/>
                <div class="form-group">
                    <label class="text-white" for="email">Email: </label>
                    <form:input class="form-control" id="email" placeholder="${utente.email}" path="email"/>
                </div>
                <div class="form-group">
                    <label class="text-white" for="password">Password: </label>
                    <form:password path="password" class="form-control " required="required" id="password" value="${utente.password}"/>
                </div>
                <div class="form-group">
                    <div class="text-white">Is admin: </div>
                    <div class="d-inline text-white">
                        False:
                        <form:radiobutton path="admin" value="false" required="required"/>
                        True:
                        <form:radiobutton path="admin" value="true"  required="required"/>
                    </div>
                </div>
                <br>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary text-center">Invia</button>
                </div>
            </form:form>
        </div>
        <div class="col-md-4 col-1"></div>
    </div>
    <br>
</div>

<jsp:include page="component/footer.jsp"/>
</body>
</html>
