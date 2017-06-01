<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <title>Calc</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="content-type" content="text/html; charset=windows-1251"/>
</head>
<body>
<div class="container">
    <div class="col-md-6 col-md-offset-3">
        <h1>Calculator</h1>
        <sf:form action="/calc" method="post" modelAttribute="calculatorForm">
            <c:if test="${not empty matherror}">
                Math error: ${matherror}
            </c:if>
            <br/>
            <sf:label path="digit">Digit: </sf:label> <sf:input path="digit" autocomplete="off"/> <sf:errors
                path="digit"/> <br/>
            <c:if test="${not empty digit}">
                Result: ${digit}
            </c:if>
            <p class="color-input-field">
                <c:if test="${not empty mathaction}">
                    Last mathaction: ${mathaction}
                </c:if>
            </p>
            <sf:button  class="btn btn-outline-primary" name="mathaction" value="+">+</sf:button>
            <sf:button  class="btn btn-outline-primary" name="mathaction" value="-">-</sf:button>
            <sf:button  class="btn btn-outline-primary" name="mathaction" value="*">*</sf:button>
            <sf:button  class="btn btn-outline-primary" name="mathaction" value="/">/</sf:button>
            <sf:button class="btn btn-outline-danger" name="mathaction" value="=">=</sf:button>
            <sf:errors path="mathaction"/>
        </sf:form>

        <br>
        <br>
        <a class="button" href="/">Main</a>

    </div>
</div>


</body>
</html>
