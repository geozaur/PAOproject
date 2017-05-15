package Models;

public class Order {
    private String id;
    private Client client;
    private Service service;
    private Product product;
    private String date;
    private boolean state;

    public Order(String id, Client client, Service service, Product product) {
        this.id = id;
        this.client = client;
        this.service = service;
        this.product = product;
        this.date = "";
        this.state = false;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    
    
}
