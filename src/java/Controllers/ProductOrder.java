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

public class ProductOrder extends HttpServlet {

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
            ArrayList<Order> productOrders = orderDAO.getProductOrders(request.getParameter("id"));

            if (productOrders != null) {
                String productName = request.getParameter("productName");

                request.setAttribute("productName", productName);
                request.setAttribute("productOrders", productOrders);

                RequestDispatcher dispatcher = request.getRequestDispatcher("productorders.jsp");
                dispatcher.forward(request, response);
            } else {
                throw new ServletException("Product has no orders yet.");
            }

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

}
