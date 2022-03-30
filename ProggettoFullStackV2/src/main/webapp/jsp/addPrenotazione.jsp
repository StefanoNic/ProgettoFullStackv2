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
    <title>Aggiungi prenotazione</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <jsp:include page="component/header.jsp"/>
</head>
<body>
<c:url var="url" value="/prenotazionePost"/>
<div class="bg-white">
    <div class="row bg-dark">
        <div class="col-md-3 col-1"></div>
        <div class="col-md-6 col-10">
            <form:form action="${url}" method="post" modelAttribute="tmpPrenotazione">
                <form:input type="hidden" path="id" name="userId" value="${loggedId}"/>
                <div class="form-group">
                    <label class="text-white" for="Veicolo">Veicolo: </label>
                    <form:select class="form-control" id="Veicolo"  required="required" placeholder="${tmpPrenotazione.veicolo.toString()}" path="veicolo.targa">
                        <form:options itemLabel="targa" items="${listOfVehicle}" />
                    </form:select>
                </div>
                <div class="md-form md-outline input-with-post-icon datepicker">
                    <label class="text-white" for="dataInizioLabel">Inserisci la data di inizio prenotazione:</label>
                    <form:input placeholder="${tmpPrenotazione.dataInizio}" type="date" id="dataInizioLabel" required="required" class="form-control"
                                path="dataInizio"/>
                </div>
                <div class="md-form md-outline input-with-post-icon datepicker">
                    <label class="text-white" for="dataFineLabel">Inserisci la data di fine prenotazione:</label>
                    <form:input placeholder="${tmpPrenotazione.dataFine}" type="date" id="dataFineLabel" required="required" class="form-control"
                                path="dataFine"/>
                </div>
                <br>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary text-center">Invia</button>
                </div>
            </form:form>
        </div>
        <div class="col-md-3 col-1"></div>
    </div>
    <br>
</div>

<jsp:include page="component/footer.jsp"/>
</body>
</html>
