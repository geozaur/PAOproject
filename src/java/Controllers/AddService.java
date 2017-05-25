package Controllers;

import Models.Service;
import Models.ServiceDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddService extends HttpServlet {

    private ServiceDAO serviceDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        serviceDAO = new ServiceDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean colored;
        if (request.getParameter("colored")==null){
            colored = false;
        }else{
            colored = true;
        }
        Service service = new Service("",
                request.getParameter("name"),
                request.getParameter("type"),
                colored,
                Integer.parseInt(request.getParameter("price")));
        
        int success;
        
        try {
            success = serviceDAO.addService(service);
            response.sendRedirect("ServiceList");
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        
        if (success == 0) {
            throw new ServletException("Could not insert service!");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}