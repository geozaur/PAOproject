package Models;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ValidatorDAO extends DataAccess {

    public void insertCompatibilities(String productId, ArrayList<String> serviceIds) throws SQLException {
        
        String sql = "INSERT INTO valid_orders (id_product,id_service) VALUES (?,?)";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);

        for (int i = 0; i < serviceIds.size(); i++) {
            statement.setString(1, productId);
            statement.setString(2, serviceIds.get(i));
            statement.addBatch();
        }
        statement.executeBatch();
        
        statement.close();
        disconnect();
    }
}
