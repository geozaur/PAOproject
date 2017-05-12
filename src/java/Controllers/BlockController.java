package Controllers;

import Models.ClientDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlockController extends HttpServlet {

    private ClientDAO clientDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        clientDAO = new ClientDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String blocked = request.getParameter("blocked");
        try {
            int success = clientDAO.switchBlockedState(username, blocked);
            if (success == 1){
                response.sendRedirect("ClientList");
            }else{
                throw new ServletException("Error switching blocked state");
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
