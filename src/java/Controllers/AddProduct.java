package Controllers;

import Models.Product;
import Models.ProductDAO;
import Models.ValidatorDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddProduct extends HttpServlet {

    private ProductDAO productDAO;
    private ValidatorDAO validatorDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        productDAO = new ProductDAO();
        validatorDAO = new ValidatorDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Product product = new Product("",
                request.getParameter("name"),
                request.getParameter("color"),
                request.getParameter("size"),
                Integer.parseInt(request.getParameter("price")));

        int i = 0;
        String serviceId = request.getParameter("service" + i++);
        ArrayList<String> serviceIds = new ArrayList();

        while (serviceId != null) {
            serviceIds.add(serviceId);
            serviceId = request.getParameter("service" + i++);
        }

        int success;

        try {
            success = productDAO.addProduct(product);
            String productId = productDAO.getIdOfProduct(product.getName(),product.getColor(),product.getSize(),product.getPrice());
            validatorDAO.insertCompatibilities(productId, serviceIds);
            response.sendRedirect("ProductList");
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
