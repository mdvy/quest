<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <link href="/css/style.css" rel="stylesheet">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no">
    <%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-latest.js"></script>

    <script type="text/javascript">


        $.fn.typewriter = function (params) {
            function writer(elem, text, speed, repeat) {
                var i = 0,
                    TextNode = document.createTextNode("");
                elem.appendChild(TextNode);
                elem.timer = setInterval(function () {
                    if (text.length === i) repeat ? (i = 0, TextNode.data = "") : clearInterval(elem.timer);
                    else
                        for (TextNode.data += text[i++];" " === text[i];) TextNode.data += text[i++]
                }, speed)
            }
            var options = {
                speed: 50,
                repeat: false
            }, options = $.extend(options, params);
            return this.each(function () {
                var text = $(this).text();
                $(this).text("");
                writer(this, text, options.speed, options.repeat)
            })
        };
    </script>
    <script type="text/javascript">
        $(window).load(function(){
            $(".demo").typewriter();
        });
    </script>
</head>

<body style="background: url('<%=request.getAttribute("image")%>') no-repeat; background-size: 100%;">

<div class="mainText">
    <div class="question">
        <div class="questionContent">
            ${name},

            <c:if test = "${ requestScope.idNotExists == true }">
                <h2> такой вариант еще не прописан в сценарии.</h2>
                <a class="start" href="/init-servlet?name=${name}">again</a><br>
            </c:if>

            <h1 class = "demo">${requestScope.questionText}</h1>

        </div>
    </div>
    <div class="answers">
    <c:forEach var="answer" items="${requestScope.answers}">


        <div><a class="answer"  href="/questServlet?answerId=${answers.indexOf(answer)}">${answer.text}</a></div>
        <br><br><br> <hr>


    </c:forEach>

    <c:if test = "${ gameOver == true }">
        <a class="answer" href="/init-servlet?name=${name}">again</a><br>
    </c:if>

    </div>


</div>

<div id = exit>
    <a class="answer"  href="/index.jsp?exit=true">выйти</a>
</div>

</body>
</html>
