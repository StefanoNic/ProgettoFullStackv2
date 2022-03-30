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
    <title>Aggiungi veicolo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <c:choose>
        <c:when test="${empty sessionScope.loggedId}">
            <c:redirect url="login"/>
        </c:when>
        <c:when test="${sessionScope.loggedId == 0}">
            <c:redirect url="login"/>
        </c:when>
        <c:when test="!${isAdmin}">
            <c:redirect url="login"/> <!-- Aggiungere parametro all'url per fare uscire un errore di qualche tipo-->
        </c:when>
    </c:choose>
    <jsp:include page="component/header.jsp"/>
</head>
<body>
<c:url var="url" value="/postVeicolo"/>
<div class="bg-white">
    <div class="row bg-dark">
        <div class="col-md-4 col-1"></div>
        <div class="col-md-4 col-10">
            <form:form action="${url}" method="post" modelAttribute="veicolo">
                <form:input type="hidden" path="id" name="veicoloId" value="${veicolo.id}"/>
                <div class="form-group">
                    <label class="text-white" for="Targa">Targa: </label>
                    <form:input class="form-control" id="Targa" placeholder="${veicolo.targa}" path="targa"/>
                </div>
                <div class="form-group">
                    <label class="text-white" for="modello">Modello: </label>
                    <form:input path="modello" class="form-control" id="modello" placeholder="${veicolo.modello}"/>
                </div>
                <div class="md-form md-outline input-with-post-icon datepicker">
                    <label class="text-white" for="immatricolazioneLabel">Inserisci la data di immatricolazione:</label>
                    <form:input placeholder="${veicolo.immatricolazione}" type="date" id="immatricolazioneLabel" class="form-control"
                                path="immatricolazione"/>
                </div>
                <div class="form-group">
                    <label class="text-white" for="tipologia">Tipologia: </label>
                    <form:input path="tipologia" class="form-control" id="tipologia" placeholder="${veicolo.tipologia}"/>
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
