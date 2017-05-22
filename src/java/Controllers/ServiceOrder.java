package Controllers;

import Models.Order;
import Models.OrderDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceOrder extends HttpServlet {

    private OrderDAO orderDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        orderDAO = new OrderDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArrayList<Order> serviceOrders = orderDAO.getServiceOrders(request.getParameter("id"));

            if (serviceOrders != null) {
                String serviceName = request.getParameter("serviceName");

                request.setAttribute("serviceName", serviceName);
                request.setAttribute("serviceOrders", serviceOrders);

                RequestDispatcher dispatcher = request.getRequestDispatcher("serviceorders.jsp");
                dispatcher.forward(request, response);
            } else {
                throw new ServletException("Service has no orders yet.");
            }

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

}
