package Controllers;

import Models.Service;
import Models.ServiceDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceList extends HttpServlet {

    private ServiceDAO serviceDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        serviceDAO = new ServiceDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<Service> serviceList = serviceDAO.getServiceList();
            
            request.setAttribute("serviceList", serviceList);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("services.jsp");
            dispatcher.forward(request, response);
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
