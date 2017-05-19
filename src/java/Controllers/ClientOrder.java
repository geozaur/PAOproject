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

public class ClientOrder extends HttpServlet {

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
            ArrayList<Order> clientOrders = orderDAO.getClientOrders(request.getParameter("username"));

            if (clientOrders != null) {
                String clientName = clientOrders.get(0).getClient().getFirstName() + " " + clientOrders.get(0).getClient().getLastName();

                request.setAttribute("clientName", clientName);
                request.setAttribute("clientOrders", clientOrders);

                RequestDispatcher dispatcher = request.getRequestDispatcher("clientorders.jsp");
                dispatcher.forward(request, response);
            } else {
                throw new ServletException("Client has no orders yet.");
            }

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

}
