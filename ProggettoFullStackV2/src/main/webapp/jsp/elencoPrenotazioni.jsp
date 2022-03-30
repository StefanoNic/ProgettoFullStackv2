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
            <c:redirect url="login"/> <!-- Aggiungere parametro all'url per fare uscire un errore di qualche tipo-->
        </c:when>
        <c:when test="${sessionScope.loggedId  == 0}">
            <c:redirect url="login"/> <!-- Aggiungere parametro all'url per fare uscire un errore di qualche tipo-->
        </c:when>
        <c:when test="!${isAdmin}">
            <c:redirect url="login"/> <!-- Aggiungere parametro all'url per fare uscire un errore di qualche tipo-->
        </c:when>
    </c:choose>
    <jsp:include page="component/header.jsp"/>

    <title>Elenco prenotazioni</title>


    <div id="container">
        <div id="content">

            <div class="row">
                <div class="col-1"></div>
            </div>

            <table border="1" class="table table-striped table-dark table-border text-center">
                <tr>
                    <th>Id utente</th>
                    <th>Id auto</th>
                    <th>Data di inizio</th>
                    <th>Data di fine</th>
                    <th>Azioni</th>
                </tr>

                <c:forEach var="tmpPrenotazione" items="${prenotazioneList}">
                    <c:url var="approvaLink" value="approvaPrenotazione">
                        <c:param name="prenotazioneId" value="${tmpPrenotazione.id}"/>
                    </c:url>
                    <c:url var="rifiutaLink" value="deletePrenotazione">
                        <c:param name="prenotazioneId" value="${tmpPrenotazione.id}"/>
                    </c:url>
                    <tr>
                        <td>${tmpPrenotazione.persona.id} </td>
                        <td>${tmpPrenotazione.veicolo.id} </td>
                        <td>${tmpPrenotazione.dataInizio} </td>
                        <td>${tmpPrenotazione.dataFine} </td>
                        <td>
                            <c:choose>
                                <c:when test="${tmpPrenotazione.approved}">
                                    <div class="text-center"> -</div>
                                </c:when>
                                <c:otherwise>
                                    <a href="${approvaLink}"> Approva</a>
                                    |
                                    <a href="${rifiutaLink}"> Rifiuta</a>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</head>
<body>


<jsp:include page="component/footer.jsp"/>
</body>
</html>
