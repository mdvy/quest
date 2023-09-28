package ru.javarush.medov.quest.controller;

import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InitServletTest {
    static int gameCounter = 0;

    @Test
    void shouldReturnValidName() {
        InitServlet initServlet = new InitServlet();
        Assertions.assertEquals("Anonymous", initServlet.validateName(null));
        Assertions.assertEquals("Anonymous", initServlet.validateName(""));
        Assertions.assertEquals("text", initServlet.validateName("<tag>text</tag>"));
        Assertions.assertEquals("Anonymous", initServlet.validateName("<tag></tag>"));
    }

    @Test
    void incrementGameCounter() {
        HttpSession session = Mockito.mock(HttpSession.class);

        Mockito.doReturn(gameCounter).when(session).getAttribute(Mockito.anyString());
        Mockito.doAnswer(x -> gameCounter++).when(session).setAttribute(Mockito.anyString(), Mockito.anyInt());

        InitServlet initServlet = new InitServlet();
        for (int k = 0; k < 10; k++)
            initServlet.incrementGameCounter(session);

        Assertions.assertEquals(10, gameCounter);
    }
}