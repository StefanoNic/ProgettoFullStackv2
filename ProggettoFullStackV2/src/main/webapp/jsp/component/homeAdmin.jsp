<%--suppress XmlPathReference --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: stefa
  Date: 09/02/2022
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="container">
    <div id="content">

        <div class="row">
            <div class="col-1"></div>
            <input type="button" value="Add customer" onclick="location.href='savePersona';" class="btn btn-primary btn-lg ">
        </div>

        <table border="1" class="table table-striped table-dark table-bordere text-center">
            <tr>
                <th>Nome</th>
                <th>Cognome</th>
                <th>Data di nascita</th>
                <th>Action</th>
            </tr>

            <c:forEach var="tmpVeicolo" items="${personaList}">
                <c:url var="tmpLink" value="UpdatePersona">
                    <c:param name="userId" value="${tmpVeicolo.id}"/>
                </c:url>
                <c:url var="deleteLink" value="deletePersona">
                    <c:param name="userId" value="${tmpVeicolo.id}"/>
                </c:url>
                <c:url var="getPrenotazioniLink" value="getPrenotazioni">
                    <c:param name="userId" value="${tmpVeicolo.id}"/>
                </c:url>
                <tr>
                    <td>${tmpVeicolo.nome}  </td>
                    <td>${tmpVeicolo.cognome}  </td>
                    <td>${tmpVeicolo.nascita}  </td>
                    <td>
                        <a href="${tmpLink}"> Update</a>
                        |
                        <a href="${deleteLink}"
                           onclick="if (!(confirm('Sei sicuro di voler eliminare questo utente?'))) return false">
                            Delete</a>
                        |
                        <a href="${getPrenotazioniLink}">
                            Prenotazioni</a>
                    </td>

                </tr>
            </c:forEach>
        </table>
    </div>
</div>

