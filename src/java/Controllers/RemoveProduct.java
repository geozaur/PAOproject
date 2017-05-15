package Controllers;

import Models.Product;
import Models.ProductDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveProduct extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int success;
        
        try {
            success = productDAO.removeProduct(request.getParameter("id"));
            response.sendRedirect("ProductList");
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        
        if (success == 0) {
            throw new ServletException("Could not insert product!");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}