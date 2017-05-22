package Models;

public class Order {

    private String id;
    private Client client;
    private Service service;
    private Product product;
    private String date;
    private boolean state;
    private String photo;
    private int price;

    public Order(String id, Client client, Service service, Product product, String photo) {
        this.id = id;
        this.client = client;
        this.service = service;
        this.product = product;
        this.date = "";
        this.state = false;
        this.photo = photo;
        this.price = service.getPrice() + product.getPrice();

    }
    
    public Order(String id, Client client, Service service, Product product, String photo, int price) {
        this.id = id;
        this.client = client;
        this.service = service;
        this.product = product;
        this.date = "";
        this.state = false;
        this.photo = photo;
        this.price = price;

    }
    
    public Order(String id, Client client, Service service, Product product, String date, boolean state, String photo, int price) {
        this.id = id;
        this.client = client;
        this.service = service;
        this.product = product;
        this.date = date;
        this.state = state;
        this.photo = photo;
        this.price = price;

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
