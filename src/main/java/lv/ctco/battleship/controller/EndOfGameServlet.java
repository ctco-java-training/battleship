package lv.ctco.battleship.controller;

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
@WebServlet(name = "EndOfGameServlet", urlPatterns = "/eog")
public class EndOfGameServlet extends HttpServlet {
    @Inject
    private PlayerManager playerManager;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Player sessionPlayer = playerManager.getPlayer();
        Player winnerPlayer = playerManager.getGame().getWinner();

        if (sessionPlayer == winnerPlayer) {
            request.getRequestDispatcher("/WEB-INF/winner.jsp").include(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/looser.jsp").include(request, response);
        }

    }
}
