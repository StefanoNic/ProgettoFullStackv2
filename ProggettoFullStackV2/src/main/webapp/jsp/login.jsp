<%--suppress XmlPathReference --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <c:choose>
        <c:when test = "${sessionScope.loggedId > 0}">
            <c:redirect url = "${pageContext.request.contextPath}/"/>
        </c:when>
    </c:choose>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<section class="vh-100" style="background-color: #508bfc;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card shadow-2-strong" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">
                        <form method = "POST" action="/loginCheck">
                            <h3 class="mb-5">Sign in</h3>
                            <div class="form-outline mb-4">
                            <input name="emailName" type="email" id="emailId" class="form-control form-control-lg" />
                            <label class="form-label" for="emailId">Email</label>
                            </div>
                            <div class="form-outline mb-4">
                            <input name="passwordName" type="password" id="passwordId" class="form-control form-control-lg" />
                            <label class="form-label" for="passwordId">Password</label>
                            </div>
                            <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>


