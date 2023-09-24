package ru.javarush.medov.quest.controller;

import com.oracle.wls.shaded.org.apache.xpath.operations.Bool;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.GregorianCalendar;

import static ru.javarush.medov.quest.controller.QuestServlet.gameService;

@WebServlet(name = "initServlet", value = "/init-servlet")
public class InitServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession currentSession = request.getSession(true);

//        boolean exit = false;
//        try{
//            exit = Boolean.parseBoolean(request.getParameter("exit"));
//        }catch (NullPointerException ignore){
//        }
//        if (exit){
//            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
//        }

        String name = request.getParameter("name");
        if (name == null || name.isEmpty()) name = "Anonymous";

        currentSession.setAttribute("name", name);
        currentSession.setAttribute("currentQuestionId", 1L);
        currentSession.setAttribute("gameOver", false);

        request.setAttribute("questionText", gameService.getQuestionTextById(1L));
        request.setAttribute("answers", gameService.getAnswersByQuestionId(1L));
        request.setAttribute("image", gameService.getImageByQuestionId(1L));

        getServletContext().getRequestDispatcher("/quest.jsp").forward(request, response);
    }

    public void destroy() {
    }
}