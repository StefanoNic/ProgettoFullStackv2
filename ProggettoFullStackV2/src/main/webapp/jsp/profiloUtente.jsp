<%--suppress XmlPathReference --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: stefa
  Date: 07/02/2022
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <c:choose>
        <c:when test="${empty sessionScope.loggedId}">
            <c:redirect url="login"/>
        </c:when>
        <c:when test="${sessionScope.loggedId== 0}">
            <c:redirect url="login"/>
        </c:when>
    </c:choose>
    <jsp:include page="component/header.jsp"/>

    <title>Profilo utente</title>
</head>
<body>

<div class="row mt-5">

    <div class="col-sm-3 col-1"></div>
    <div class="col-sm-6 col-10 bg-dark text-white">
        <div class="row">
            <div class="col-6"> Email: ${utente.email}</div>
            <div class="col-6"> Password: ${utente.password}</div>
        </div>
        <br>
        <div class="row">
            <div class="col-6">
                Ruolo:
                <c:choose>
                    <c:when test="${utente.admin}"> ADMIN </c:when>
                    <c:otherwise> Customer
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

        <br>
        <div class="row">
            <div class="col-6">Nome: ${persona.nome}</div>
            <div class="col-6"> Cognome: ${persona.cognome} </div>
        </div>
        <br>
        <div class="row">
            <div class="col-6"> Data di nascita: ${persona.nascita} </div>
            <div class="col-6">
                <a class="btn btn-primary" href="Logout" role="button">Logout</a>
                <c:choose>
                    <c:when
                            test="${!utente.admin}"><a class="btn btn-primary" href="UpdateProfilo" role="button">Modifica Info</a>
                    </c:when>
                </c:choose>
            </div>
        </div>
        <br>
    </div>
    <div class="col-sm-3 col-1"></div>
</div>

<jsp:include page="component/footer.jsp"/>
</body>
</html>
