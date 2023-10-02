package ru.javarush.medov.quest.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.javarush.medov.quest.service.GameService;

import java.io.IOException;

@WebServlet(name = "questServlet", value = "/questServlet")
public class QuestServlet extends HttpServlet {

    static final GameService gameService = new GameService("questions.json");

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession currentSession = request.getSession();

        Integer answerId = null;
        Long currentQuestionId = null;
        try {
            currentQuestionId = Long.parseLong(request.getParameter("id"));
            answerId = Integer.parseInt(request.getParameter("answerId"));
        } catch (NumberFormatException ignore) {
        }

        if (currentQuestionId == null)
            currentQuestionId = (Long) currentSession.getAttribute("currentQuestionId");

        Long nextQuestionId;
        if (answerId == null) {
            nextQuestionId = currentQuestionId;
        } else
            nextQuestionId = gameService.getNextQuestionIdByAnswer(currentQuestionId, answerId);

        if (gameService.getQuestionById(nextQuestionId) == null) {
            request.setAttribute("idNotExists", true);
            getServletContext().getRequestDispatcher("/quest.jsp").forward(request, response);
        }

        if (gameService.getAnswersByQuestionId(nextQuestionId) == null) {
            currentSession.setAttribute("gameOver", true);
        } else
            request.setAttribute("answers", gameService.getAnswersByQuestionId(nextQuestionId));

        request.setAttribute("questionText", gameService.getQuestionTextById(nextQuestionId));
        request.setAttribute("image", gameService.getImageByQuestionId(nextQuestionId));
        request.setAttribute("id", nextQuestionId);

        currentSession.setAttribute("currentQuestionId", nextQuestionId);

        getServletContext().getRequestDispatcher("/quest.jsp").forward(request, response);
    }
}