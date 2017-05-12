package Controllers;

import Models.Client;
import Models.ClientDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupController extends HttpServlet {

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
        Client client = new Client(request.getParameter("username"),
                request.getParameter("password"),
                request.getParameter("firstName"),
                request.getParameter("lastName"),
                request.getParameter("country"),
                request.getParameter("city"),
                request.getParameter("address"),
                request.getParameter("securityQuestion"),
                request.getParameter("securityAnswer"));

        try {
            clientDAO.signUp(client);
            response.sendRedirect("index.html");
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

}
