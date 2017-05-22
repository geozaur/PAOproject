package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends DataAccess {

    private ClientDAO clientDAO = new ClientDAO();
    private ServiceDAO serviceDAO = new ServiceDAO();
    private ProductDAO productDAO = new ProductDAO();

    public List<Order> getOrderList() throws SQLException {

        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT * FROM orders";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            String id = rs.getString("id");
            String username = rs.getString("username_client");
            String idService = rs.getString("id_service");
            String idProduct = rs.getString("id_product");
            String date = rs.getString("date");
            Boolean state = rs.getBoolean("state");
            String photo = rs.getString("photo");
            int price = rs.getInt("total_price");

            orderList.add(new Order(id, clientDAO.getClient(username),
                    serviceDAO.getService(idService),
                    productDAO.getProduct(idProduct),
                    date, state, photo, price));
        }

        statement.close();
        disconnect();

        return orderList;
    }

    public int addOrder(Order order) throws SQLException {
        String sql = "INSERT INTO orders (username_client, id_service, id_product, photo, total_price) VALUES (?,?,?,?,?)";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, order.getClient().getUsername());
        statement.setString(2, order.getService().getId());
        statement.setString(3, order.getProduct().getId());
        statement.setString(4, order.getPhoto());
        statement.setInt(5, order.getPrice());

        int success = statement.executeUpdate();

        statement.close();
        disconnect();
        return success;
    }

    public ArrayList<Order> getClientOrders(String username) throws SQLException {
        String sql = "SELECT * FROM orders WHERE username_client = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, username);

        ResultSet rs = statement.executeQuery();

        ArrayList<Order> clientOrders = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString("id");
            Client client = clientDAO.getClient(username);
            Service service = serviceDAO.getService(rs.getString("id_service"));
            Product product = productDAO.getProduct(rs.getString("id_product"));
            String date = rs.getString("date");
            Boolean state = rs.getBoolean("state");
            String photo = rs.getString("photo");
            int price = rs.getInt("total_price");

            clientOrders.add(new Order(id, client, service, product, date, state, photo, price));
        }

        statement.close();
        disconnect();

        return clientOrders;
    }

    public boolean isValidOrder(String id_product, String id_service) throws SQLException {
        String sql = "SELECT id FROM valid_orders WHERE id_product = ? AND id_service = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, id_product);
        statement.setString(2, id_service);

        ResultSet rs = statement.executeQuery();

        boolean result = false;

        if (rs.next()) {
            result = true;
        }

        statement.close();
        disconnect();

        return result;
    }
    
    public ArrayList<Order> getProductOrders(String productId) throws SQLException {
        String sql = "SELECT * FROM orders WHERE id_product = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, productId);

        ResultSet rs = statement.executeQuery();

        ArrayList<Order> productOrders = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString("id");
            Client client = clientDAO.getClient(rs.getString("username_client"));
            Service service = serviceDAO.getService(rs.getString("id_service"));
            String date = rs.getString("date");
            Boolean state = rs.getBoolean("state");
            String photo = rs.getString("photo");
            int price = rs.getInt("total_price");

            productOrders.add(new Order(id, client, service, date, state, photo, price));
        }

        statement.close();
        disconnect();

        return productOrders;
    }
    
    public ArrayList<Order> getServiceOrders(String serviceId) throws SQLException {
        String sql = "SELECT * FROM orders WHERE id_service = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, serviceId);

        ResultSet rs = statement.executeQuery();

        ArrayList<Order> serviceOrders = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString("id");
            Client client = clientDAO.getClient(rs.getString("username_client"));
            Product product = productDAO.getProduct(rs.getString("id_product"));
            String date = rs.getString("date");
            Boolean state = rs.getBoolean("state");
            String photo = rs.getString("photo");
            int price = rs.getInt("total_price");

            serviceOrders.add(new Order(id, client, product, date, state, photo, price));
        }

        statement.close();
        disconnect();

        return serviceOrders;
    }
}
