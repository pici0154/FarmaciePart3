package Domain;

public class Medicament {

    private String id;
    private String name;
    private String producator;
    private double price;
    private boolean reteta;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setNume(String name) {
        this.name = name;
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getReteta() {
        return reteta;
    }

    public void setReteta(boolean reteta) {
        this.reteta = reteta;
    }

    public Medicament(String id, String name, String producator, double price,boolean reteta) {
        this.id = id;
        this.name = name;
        this.producator = producator;
        this.price = price;
        this.reteta = reteta;
    }



}
