package Controllers;

import Models.Product;
import Models.ProductDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductList extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<Product> productList = productDAO.getProductList();
            
            request.setAttribute("productList", productList);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("products.jsp");
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
