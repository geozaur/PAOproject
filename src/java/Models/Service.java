package Models;

public class Service {

    private String id;
    private String name;
    private String type;
    private boolean colored;
    private int price;

    public Service(String id, String name, String type, boolean colored, int price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.colored = colored;
        this.price = price;
    }

    public Service(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isColored() {
        return colored;
    }

    public void setColored(boolean colored) {
        this.colored = colored;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
