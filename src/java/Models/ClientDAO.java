package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends DataAccess {

    public boolean signUp(Client client) throws SQLException {
        String sql = "INSERT INTO clients VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        connect();
        

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, client.getUsername());
        statement.setString(2, client.getPassword());
        statement.setString(3, client.getFirstName());
        statement.setString(4, client.getLastName());
        statement.setString(5, client.getPhone());
        statement.setString(6, client.getEmail());
        statement.setString(7, client.getCountry());
        statement.setString(8, client.getCity());
        statement.setString(9, client.getAddress());
        statement.setBoolean(10, client.isAccountType());
        statement.setString(11, client.getSecurityQuestion());
        statement.setString(12, client.getSecurityAnswer());
        statement.setBoolean(13, false);

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;

    }

    public int signIn(String username, String password) throws SQLException {
        String sql = "SELECT password, blocked, account_type FROM clients WHERE username = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, username);

        ResultSet rs = statement.executeQuery();

        String realPassword = null;
        boolean isAdmin = false;
        boolean blocked = false;
        if (rs.next()) {
            realPassword = rs.getString("password");
            isAdmin = rs.getBoolean("account_type");
            blocked = rs.getBoolean("blocked");
        }

        statement.close();
        disconnect();

        if (password.equals(realPassword) && !blocked) {
            if (!isAdmin) {
                return 0;
            }
            return 1;

        }

        return -1;
    }

    public boolean resetPassword(String username, String securityQuestion, String securityAnswer, String newPassword) throws SQLException {
        String sql = "SELECT username FROM clients WHERE security_question = ? AND security_answer = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, securityQuestion);
        statement.setString(2, securityAnswer);

        ResultSet rs = statement.executeQuery();

        String usernameResult = null;

        while (rs.next()) {
            usernameResult = rs.getString("username");

            if (usernameResult.equals(username)) {
                String update = "UPDATE clients SET password = ? WHERE username = ?";

                PreparedStatement updateStmt = jdbcConnection.prepareStatement(update);
                updateStmt.setString(1, newPassword);
                updateStmt.setString(2, username);

                updateStmt.executeUpdate();

                statement.close();
                updateStmt.close();
                disconnect();

                return true;
            }
        }

        statement.close();
        disconnect();

        return false;
    }
    
    public List<Client> getClientList() throws SQLException{
        List<Client> clientList = new ArrayList<>();
        String sql = "SELECT username,first_name,last_name,phone,email,country,city,address,blocked FROM clients WHERE account_type = 0";
        
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        
        while(rs.next()){
            String username = rs.getString("username");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            String country = rs.getString("country");
            String city = rs.getString("city");
            String address = rs.getString("address");
            Boolean blocked = rs.getBoolean("blocked");
            
            clientList.add(new Client(username,"",firstName,lastName,phone,email,country,city,address,"","",blocked));
        }
        
        statement.close();
        disconnect();
        
        return clientList;
    }
    
    public int switchBlockedState(String username, String blocked) throws SQLException{
        String sql = "UPDATE clients SET blocked = ? WHERE username = ?";
        
        connect();
        
        if (blocked.equals("0")){
            blocked = "1";
        }else{
            blocked = "0";
        }
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, blocked);
        statement.setString(2, username);
        int success = statement.executeUpdate();
        
        statement.close();
        disconnect();
        return success;
    }
    
    public Client getClient(String username) throws SQLException {
        String sql = "SELECT * FROM clients WHERE username = ?";
        
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, username);
        
        ResultSet rs = statement.executeQuery();
        rs.next();
        Client client = new Client(
                username,
                "",
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("phone"),
                rs.getString("email"),
                rs.getString("country"),
                rs.getString("city"),
                rs.getString("address"),
                "",
                "",
                rs.getBoolean("blocked"));
        
        statement.close();
        disconnect();
        
        return client;
    }
}
