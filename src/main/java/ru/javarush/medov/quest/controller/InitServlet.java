package ru.javarush.medov.quest.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static ru.javarush.medov.quest.controller.QuestServlet.gameService;

@WebServlet(name = "initServlet", value = "/init-servlet")
public class InitServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession currentSession = request.getSession(true);

        String name = validateName(request.getParameter("name"));

        currentSession.setAttribute("name", name);
        currentSession.setAttribute("currentQuestionId", 1L);
        currentSession.setAttribute("gameOver", false);

        incrementGameCounter(currentSession);

        request.setAttribute("questionText", gameService.getQuestionTextById(1L));
        request.setAttribute("answers", gameService.getAnswersByQuestionId(1L));
        request.setAttribute("image", gameService.getImageByQuestionId(1L));
        request.setAttribute("id", 1L);

        getServletContext().getRequestDispatcher("/quest.jsp").forward(request, response);
    }

    public String validateName(String name) {
        if (name == null)
            return "Anonymous";
        name = name.replaceAll("<[^>]*>", "").trim();
        if (name.isEmpty())
            return "Anonymous";
        else
            return name;
    }

    public void incrementGameCounter(HttpSession session) {
        Integer gameCounter = (Integer) session.getAttribute("gameCounter");
        if (gameCounter == null)
            gameCounter = -1;
        session.setAttribute("gameCounter", gameCounter + 1);
    }

}