package Controllers;

import Models.ClientDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SigninController extends HttpServlet {

    private final int SESSIONTIME = 1800; // 30 * 60 seconds
    private ClientDAO clientDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        clientDAO = new ClientDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            int success = clientDAO.signIn(username, password);
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(SESSIONTIME);
            switch (success) {
                case 0:
                    session.setAttribute("username", username);
                    session.setAttribute("type", 0);
                    response.sendRedirect("userpage.jsp");
                    break;
                case 1:
                    session.setAttribute("username", username);
                    session.setAttribute("type", 1);
                    response.sendRedirect("admin/index.jsp");
                    break;
                default:
                    throw new ServletException("Account does not exist or it is blocked");
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

}
