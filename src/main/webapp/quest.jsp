<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="/css/style.css" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <script src=/js/my.js></script>

</head>

<body style="background: url('<%=request.getAttribute("image")%>') no-repeat; background-size: 100%;">

    <div class="mainText">
        <div class="question">
            <div class="questionContent">
                ${name},

                <c:if test = "${ requestScope.idNotExists == true }">
                    <h2> такой вариант еще не прописан в сценарии.</h2>
                    <div class="answerContent"><a class="answer" href="/init-servlet?name=${name}">again</a></div>>
                </c:if>

                <h1 class = "typing">${requestScope.questionText}</h1>

            </div>
        </div>

        <div class="answers">
        <c:forEach var="answer" items="${requestScope.answers}">

                <div class="answerContent"><a class="answer"  href="/questServlet?id=${id}&answerId=${answers.indexOf(answer)}">${answer.text}</a></div>
                <br>

        </c:forEach>

        <c:if test = "${ gameOver == true }">
            <div class="answerContent"><a class="answer" href="/init-servlet?name=${name}">again</a></div>
        </c:if>

        </div>
    </div>


    <div id = "exit">
        <div style="color: #b7b7b7; text-align: left">
            имя: ${name}<br>
            кол-во игр: ${gameCounter}<br>
        </div>

        <div>
            <a class="answer"  href="/index.jsp?exit=true">выйти</a>
        </div>
    </div>

</body>
</html>
