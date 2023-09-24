<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<% if (request.getParameter("exit") != null ) request.getSession(true).invalidate(); %>
<% if (request.getSession().getAttribute("name") != null ) response.sendRedirect("/questServlet"); %>


<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="/css/style.css" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script src=/js/my.js></script>

</head>


<body>
    <div class="start_form">
        <div class="questionContent">
            <h1 style="font-size: 300%;">
                Введите имя, чтобы <br><a class="start" href="javascript://" onclick="sendForm()">начать</a><br>квест...</h1>
                <form id="myForm" action = "/init-servlet" method = "GET">
                    <input style="font-weight: bold" class="form-control" type = "text" name = "name"/>
                    <br>
                </form>
            </h1>
        </div>
    </div>
</body>
</html>