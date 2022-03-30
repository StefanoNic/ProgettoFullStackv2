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
            <c:when test="${empty utenteId}"> <c:redirect url="login"/> <!-- Aggiungere parametro all'url per fare uscire un errore di qualche tipo--></c:when>
            <c:when test="${utenteId !=  sessionScope.loggedId}"> <c:redirect url="login"/> </c:when>
        </c:when>
    </c:choose>
    <jsp:include page="component/header.jsp"/>
</head>
<body>
<c:url var="url" value="/personaPost"/>
<div class="bg-white">
    <div class="row bg-dark">
        <div class="col-md-4 col-1"></div>
        <div class="col-md-4 col-10">
            <form:form action="${url}" method="post" modelAttribute="persona">
                <form:input type="hidden" path="id" name="userId" value="${persona.id}"/>
                <div class="form-group">
                    <label class="text-white" for="Nome">Nome: </label>
                    <form:input class="form-control" id="Nome" placeholder="${persona.nome}" path="nome"/>
                </div>
                <div class="form-group">
                    <label class="text-white" for="Cognome">Cognome: </label>
                    <form:input path="cognome" class="form-control" id="Cognome" placeholder="${persona.cognome}"/>
                </div>
                <div class="md-form md-outline input-with-post-icon datepicker">
                    <label class="text-white" for="nascitaLabel">Inserisci la tua data di nascita:</label>
                    <form:input placeholder="${persona.nascita}" type="date" id="nascitaLabel" required="required" class="form-control"
                                path="nascita"/>
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
