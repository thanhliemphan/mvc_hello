<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href='${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/css/bootstrap.min.css' />
    <script src="${pageContext.request.getContextPath()}/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <title>Spring MVC Form Handling</title>

</head>
<body>
    <div class="d-flex justify-content-center">
        <h2>User Registration Form</h2>
    </div>
    <mvc:form class="d-flex justify-content-center" modelAttribute="user" action="result">
        <table>
            <tr>
                <td>First Name (*)</td>
                <td><mvc:input class="form-control" path="name" required="true" placeholder="First Name"/></td>
            </tr>
            <tr>
                <td>Last Name (*)</td>
                <td><mvc:input class="form-control" path="lastname" required="true" placeholder="Last Name"/></td>
            </tr>
            <tr>
                <td>Password (*)</td>
                <td><mvc:password class="form-control" path="password" required="true" placeholder="Password"/></td>
            </tr>
            <tr>
                <td>Detail</td>
                <td><mvc:textarea class="form-control" path="detail" required="true" placeholder="Detail information"/></td>
            </tr>
            <tr>
                <td>Birth Date</td>
                <td><mvc:input class="form-control" path="birthDate" type="Date"/></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td><mvc:radiobuttons class="form-check-input" path="gender" items="${genders}"/></td>
            </tr>
            <tr>
                <td>Country</td>
                <td><mvc:select class="form-select" path="country" items="${countries}"/></td>
            </tr>
            <tr>
                <td>Non Smoking</td>
                <td><mvc:checkbox class="form-check-input" path="nonSmoking" checkbox="true"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input class="btn btn-primary" type="submit" value="Submit">
                </td>
            </tr>
        </table>
    </mvc:form>
</body>
</html>