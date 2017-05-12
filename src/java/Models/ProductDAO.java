package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends DataAccess {
    public List<Product> getProductList() throws SQLException{
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM products";
        
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        
        while(rs.next()) {
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
}
