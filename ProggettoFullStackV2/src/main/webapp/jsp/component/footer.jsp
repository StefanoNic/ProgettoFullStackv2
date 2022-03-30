<%--
  Created by IntelliJ IDEA.
  User: stefa
  Date: 04/02/2022
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Footer -->
<footer class="text-center text-lg-start bg-light text-muted">

    <!-- Section: Links  -->
    <section class="">
        <div class="container text-center text-md-start mt-5">
            <!-- Grid row -->
            <div class="row mt-3">
                <!-- Grid column -->
                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                    <!-- Content -->
                    <h6 class="text-uppercase fw-bold mb-4 text-center">
                        <i class="fas fa-gem me-3"></i>Company name
                    </h6>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolore doloribus eum expedita nesciunt officiis perspiciatis praesentium soluta suscipit tenetur ut.
                    </p>
                </div>
                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                </div>
                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                </div>
                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase text-center fw-bold mb-4 ">
                        Contact
                    </h6>
                    <p><i class="fas fa-home me-3"></i> CittaAzienda, CI 84000, IT</p>
                    <p>
                        <i class="fas fa-envelope me-3"></i>
                        info@example.com
                    </p>
                    <p><i class="fas fa-phone me-3"></i> + 01 234 567 89</p>
                    <p><i class="fas fa-print me-3"></i> + 01 234 567 89</p>
                </div>
                <!-- Grid column -->
            </div>
            <!-- Grid row -->
        </div>
    </section>
    <!-- Section: Links  -->

    <!-- Copyright -->
    <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
        <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <jsp:useBean id="now" class="java.util.Date" />
        <fmt:formatDate var="year" value="${now}" pattern="yyyy" />
        © ${year} Copyright:
        <a class="text-reset fw-bold" href="#">Company Name</a>
    </div>
    <!-- Copyright -->
</footer>
<!-- Footer -->