package model;

import java.util.ArrayList;
import java.util.List;

public class Brand {
    private Long id;
    private String name;
    private String dateCreated;
    private int locationCount;

    public Brand(){}

    public Brand(Long id, String name, String dateCreated, int locationCount) {
        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
        this.locationCount = locationCount;
    }

    private List<Product> products = new ArrayList<>();


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId(){return id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getLocationCount() {
        return locationCount;
    }

    public void setLocationCount(int locationCount) {
        this.locationCount = locationCount;
    }

    public List<Product> getProducts(){ return products;}

    public boolean canAddProduct(){ return products.size()<5;}

    public void addProduct(Product p){
        if (canAddProduct()){
            products.add(p);
        }
    }
}



