<%--suppress XmlPathReference --%>


<%@ page import="java.time.LocalDate" %>
<%@ page import="static java.time.temporal.ChronoUnit.DAYS" %>
<%@ page import="java.time.temporal.Temporal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--suppress XmlPathReference --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: stefa
  Date: 10/02/2022
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>

<div id="container">
    <div id="content">

        <div class="row">
            <div class="col-1"></div>
            <input type="button" value="Add prenotazione" onclick="location.href='addPrenotazione';" class="btn btn-primary btn-lg ">
        </div>
        <table border="1" class="table table-striped table-dark table-border text-center">
            <tr>

                <th>Targa auto:</th>
                <th>Data di inizio</th>
                <th>Data di fine</th>
                <th>Azioni</th>
            </tr>
            <c:forEach var="tmpPrenotazione" items="${prenotazioneList}">
                <c:url var="updateLink" value="updatePrenotazione">
                    <c:param name="prenotazioneId" value="${tmpPrenotazione.id}"/>
                </c:url>
                <c:url var="rifiutaLink" value="deletePrenotazioneUser">
                    <c:param name="prenotazioneId" value="${tmpPrenotazione.id}"/>
                </c:url>
                <tr>

                    <td>${tmpPrenotazione.veicolo.targa}  </td>
                    <td>${tmpPrenotazione.dataInizio}  </td>
                    <td>${tmpPrenotazione.dataFine}  </td>
                    <td>

                        <c:set var="DebugDataInizio" value="${tmpPrenotazione.dataInizio}"/>
                        <c:set var="DAYS" value="<%=java.time.temporal.ChronoUnit.DAYS%>" />
                        <c:choose>
                            <c:when test="${ DAYS.between(tmpPrenotazione.dataInizio, LocalDate.now()) >2}">
                                <% System.out.println(DAYS.between((Temporal) pageContext.findAttribute("DebugDataInizio"), LocalDate.now())); %>
                                <div class="text-center"> - </div>
                            </c:when>
                            <c:otherwise>
                                <% System.out.println(DAYS.between((Temporal) pageContext.findAttribute("DebugDataInizio"), LocalDate.now())); %>
                                <a href="${updateLink}"> Modifica</a>
                                |
                                <a href="${rifiutaLink}"> Elimina</a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
