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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <!--Vedere interceptor-->
    <c:choose>
    <c:when test = "${empty sessionScope.loggedId}">
        <c:redirect url = "login"/>
    </c:when>
    <c:when test = "${sessionScope.loggedId == 0}">
        <c:redirect url = "login"/>
    </c:when>
    </c:choose>
    <jsp:include page="component/header.jsp"/>

    <title>Parco Auto</title>
</head>
<body>

<div id="container">
    <div id="content">

        <c:choose>
            <c:when test="${sessionScope.isAdmin}">
                <div class="row">
                    <div class="col-1"></div>
                    <input type="button" value="Add veicolo" onclick="location.href='saveVeicolo';" class="btn btn-primary btn-lg ">
                </div>
            </c:when>
        </c:choose>
        <table border="1" class="table table-striped table-dark table-bordere text-center">
            <tr>
                <th>Targa</th>
                <th>Modello</th>
                <th>Immatricolazione</th>
                <th>Tipologia</th>
                <th>Azioni</th>
            </tr>

            <c:forEach var="tmpVeicolo" items="${veicoliList}">
                <c:url var="tmpLink" value="UpdateVeicolo">
                    <c:param name="veicoloId" value="${tmpVeicolo.id}"/>
                </c:url>
                <c:url var="deleteLink" value="deleteVeicolo">
                    <c:param name="veicoloId" value="${tmpVeicolo.id}"/>
                </c:url>
                <tr>
                    <td>${tmpVeicolo.targa}  </td>
                    <td>${tmpVeicolo.modello}  </td>
                    <td>${tmpVeicolo.immatricolazione}  </td>
                    <td>${tmpVeicolo.tipologia}  </td>
                    <c:choose>
                        <c:when test="${isAdmin}">
                            <td>
                                <a href="${tmpLink}"> Update</a>
                                |
                                <a href="${deleteLink}"
                                   onclick="if (!(confirm('Sei sicuro di voler eliminare questo veicolo?'))) return false">
                                    Delete</a>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td> -
                            </td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<jsp:include page="component/footer.jsp"/>
</body>
</html>
