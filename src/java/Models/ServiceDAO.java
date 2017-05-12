package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO extends DataAccess {
    public List<Service> getServiceList() throws SQLException{
        List<Service> serviceList = new ArrayList<>();
        String sql = "SELECT * FROM services";
        
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        
        while(rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String type = rs.getString("type");
            boolean colored = rs.getBoolean("colored");
            int price = rs.getInt("price");
            
            serviceList.add(new Service(id, name, type, colored, price));
        }
        
        statement.close();
        disconnect();
        
        return serviceList;
    }
}
