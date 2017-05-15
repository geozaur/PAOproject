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
    
    public int addService(Service service) throws SQLException {
        String sql = "INSERT INTO services (name, type, colored, price) VALUES (?,?,?,?)";
        
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, service.getName());
        statement.setString(2, service.getType());
        statement.setBoolean(3, service.isColored());
        statement.setInt(4, service.getPrice());
        
        int success = statement.executeUpdate();
        
        statement.close();
        disconnect();
        return success;
    }
    
    public int removeService(String id) throws SQLException {
        String sql = "DELETE FROM services WHERE id = ?";
        
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, id);
        
        int success = statement.executeUpdate();
        
        statement.close();
        disconnect();
        return success;
    }
    
    public Service getService(String id) throws SQLException {
        String sql = "SELECT * FROM services WHERE id = ?";
        
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, id);
        
        ResultSet rs = statement.executeQuery();
        rs.next();
        Service service = new Service(
                id,
                rs.getString("name"),
                rs.getString("type"),
                rs.getBoolean("colored"),
                rs.getInt("price"));
        
        statement.close();
        disconnect();
        
        return service;
    }
}
