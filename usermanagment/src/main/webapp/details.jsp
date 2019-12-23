<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="user" class="usermanagment.src\.ain.java.ua.nure.kn.pankratov.domain.User" scope="session"></jsp:useBean>
<html>
<head><title>User management. Details</title></head>
<body>
<form action="<%=request.getContextPath()%>/details" method="post">
    <p>First name: ${user.firstName}</p>
    <p>Last name: ${user.lastName}</p>
    <p>Date of birth: <fmt:formatDate value="${user.dateOfBirth}" type="date" dateStyle="medium"/></p>
    <input type="submit" name="backButton" value="Back">
</form>
<c:if test='${request.Scope.error != null}'>
    <script type="text/javascript">
        alert('${request.Scope.error}');
    </script>
</c:if>
</body>
</html>