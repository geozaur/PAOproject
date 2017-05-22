package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends DataAccess {

    public List<Product> getProductList() throws SQLException {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM products";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String color = rs.getString("color");
            String size = rs.getString("size");
            int price = rs.getInt("price");

            productList.add(new Product(id, name, color, size, price));
        }

        statement.close();
        disconnect();

        return productList;
    }

    public int addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO products (name, color, size, price) VALUES (?,?,?,?)";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, product.getName());
        statement.setString(2, product.getColor());
        statement.setString(3, product.getSize());
        statement.setInt(4, product.getPrice());

        int success = statement.executeUpdate();

        statement.close();
        disconnect();
        return success;
    }

    public int removeProduct(String id) throws SQLException {
        String sql = "DELETE FROM products WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, id);

        int success = statement.executeUpdate();

        statement.close();
        disconnect();
        return success;
    }

    public Product getProduct(String id) throws SQLException {
        String sql = "SELECT * FROM products WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, id);

        ResultSet rs = statement.executeQuery();
        rs.next();
        Product product = new Product(
                id,
                rs.getString("name"),
                rs.getString("color"),
                rs.getString("size"),
                rs.getInt("price"));

        statement.close();
        disconnect();

        return product;
    }
}
