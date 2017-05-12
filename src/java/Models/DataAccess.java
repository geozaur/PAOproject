package Models;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataAccess {

    private Context initCtx;
    private Context envCtx;
    private DataSource dbRes;

    protected Connection jdbcConnection;

    public DataAccess() {
        try {
            initCtx = new InitialContext();
            envCtx = (Context) initCtx.lookup("java:comp/env");
            dbRes = (DataSource) envCtx.lookup("jdbcPaoProject");
        } catch (NamingException ex) {
            System.out.println("erroneous link to resource");
        }
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            jdbcConnection = dbRes.getConnection();
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
}
