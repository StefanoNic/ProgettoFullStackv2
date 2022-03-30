<%--suppress XmlPathReference --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <c:choose>
        <c:when test = "${empty loggedId}">
            <c:redirect url = "login"/>
        </c:when>
        <c:when test = "${loggedId == 0}">
            <c:redirect url = "login"/> <!-- Aggiungere parametro all'url per fare uscire un errore di qualche tipo-->
        </c:when>
    </c:choose>
    <jsp:include page="component/header.jsp"/>
</head>
<body>
<div class="view">
    <div class="pages">
        <c:choose>
            <c:when test = "${isAdmin}">
                <c:import url="/homeAdmin" />
            </c:when>
            <c:otherwise>
                <c:import url="/getPersonalPrenotazioni" />
            </c:otherwise>
        </c:choose>
    </div>
</div>
<jsp:include page="component/footer.jsp" />
</body>
</html>