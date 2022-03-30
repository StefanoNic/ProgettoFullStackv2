<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<title>${param.pageTitle}</title>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand">Navbar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/">Homepage </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ParcoAuto">Parco auto</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ProfiloUtente">Profilo utente</a>
                </li>


                <c:choose>
                    <c:when test = "${sessionScope.isAdmin eq 'true'}">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/ElencoPrenotazioni">Elenco prenotazioni</a>
                        </li>
                    </c:when>
                </c:choose>
            </ul>
            <form class="row ms-auto">
                <div class="col">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                </div>
                <div class="col-auto">
                    <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
                </div>
            </form>
        </div>
    </nav>