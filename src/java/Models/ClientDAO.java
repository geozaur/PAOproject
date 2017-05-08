package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO extends DataAccess {

    public ClientDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        super(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public boolean signUp(Client client) throws SQLException {
        String sql = "INSERT INTO clients VALUES (?,?,?,?,?,?,?,?,?,?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, client.getUsername());
        statement.setString(2, client.getPassword());
        statement.setString(3, client.getFirstName());
        statement.setString(4, client.getLastName());
        statement.setString(5, client.getCountry());
        statement.setString(6, client.getCity());
        statement.setString(7, client.getAddress());
        statement.setBoolean(8, client.isAccountType());
        statement.setString(9, client.getSecurityQuestion());
        statement.setString(10, client.getSecurityAnswer());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;

    }

    public boolean signIn(String username, String password) throws SQLException {
        String sql = "SELECT password, blocked FROM clients WHERE username = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, username);

        ResultSet rs = statement.executeQuery();

        String realPassword = null;
        boolean blocked = false;
        if (rs.next()) {
            realPassword = rs.getString("password");
            blocked = rs.getBoolean("blocked");
        }

        statement.close();
        disconnect();

        if (password.equals(realPassword) && !blocked) {
            return true;
        }

        return false;
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
}
