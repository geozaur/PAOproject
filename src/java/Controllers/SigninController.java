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

    private ClientDAO clientDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        clientDAO = new ClientDAO(jdbcURL, jdbcUsername, jdbcPassword);
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
            HttpSession session;
            switch (success) {
                case 0:
                    session = request.getSession();
                    session.setAttribute("username", username);
                    session.setAttribute("type", 0);
                    response.sendRedirect("userpage.jsp");
                    break;
                case 1:
                    session = request.getSession();
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
