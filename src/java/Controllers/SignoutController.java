package Controllers;

import Models.ClientDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignoutController extends HttpServlet {

    private ClientDAO clientDAO;

    @Override
    public void init() throws ServletException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        Integer type = (Integer) session.getAttribute("type");
        
        session.invalidate();
        
        if (type == 1) {
            response.sendRedirect("../index.html");
        } else {
            response.sendRedirect("index.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
