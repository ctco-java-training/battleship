package lv.ctco.battleship.controller;

import lv.ctco.battleship.model.Game;
import lv.ctco.battleship.model.Player;
import lv.ctco.battleship.model.PlayerManager;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Dimitrijs Fedotovs <a href="http://www.bug.guru">www.bug.guru</a>
 * @version 1.0
 * @since 1.0
 */
@WebServlet(name = "FireServlet", urlPatterns = "/fire")
public class FireServlet extends HttpServlet {

    @Inject
    private PlayerManager playerManager;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Player player = playerManager.getPlayer();
        Game game = playerManager.getGame();
        if (player == game.getCurrentPlayer()) {
            request.getRequestDispatcher("/WEB-INF/fire.jsp").include(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/wait-opponent-fire.jsp").include(request, response);
        }
    }
}
