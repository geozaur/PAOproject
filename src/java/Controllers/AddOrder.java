package Controllers;

import Models.Client;
import Models.Order;
import Models.OrderDAO;
import Models.Product;
import Models.ProductDAO;
import Models.Service;
import Models.ServiceDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddOrder extends HttpServlet {

    private OrderDAO orderDAO;
    private ProductDAO productDAO;
    private ServiceDAO serviceDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        orderDAO = new OrderDAO();
        productDAO = new ProductDAO();
        serviceDAO = new ServiceDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Product product = productDAO.getProduct(request.getParameter("product"));
            Service service = serviceDAO.getService(request.getParameter("service"));
            
            if (orderDAO.isValidOrder(product.getId(), service.getId())) {
                request.setAttribute("valid", "true");

                String photo = request.getParameter("photo");
                int price = product.getPrice() + service.getPrice();

                Order order = new Order("",
                        new Client(request.getParameter("username")),
                        service, product, photo, price);

                int success;

                try {
                    success = orderDAO.addOrder(order);
                } catch (SQLException ex) {
                    throw new ServletException(ex);
                }

                if (success == 0) {
                    throw new ServletException("Could not place order!");
                }
            } else {
                request.setAttribute("valid", "false");
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("TestController");
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            throw new ServletException("Database error!");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
