package data;

import model.Brand;
import model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ShopData {

    private final Map<Long, Brand> brands = new LinkedHashMap<>();
    private final Map<Long, Product> products = new LinkedHashMap<>();

    private long brandSeq=1;
    private long prodSeq=1;

    public ShopData(){
       Brand seiko =  saveBrand(new Brand(null,"Seiko","1881",310));
       Brand casio =  saveBrand(new Brand(null,"Casio","1946",290));

       Product seiko5 =  saveProducts(new Product(null,"5",300,"Srebreni"));
       Product prospex = saveProducts(new Product(null,"Prospex",610,"Crni mat"));
       Product presage= saveProducts(new Product(null,"Presage",1200,"Najskuplji model"));

       Product gshock= saveProducts(new Product(null,"GSHOCK",300,"zeleni camo"));
       Product edifice = saveProducts(new Product(null,"EDIFICE",410,"Sportski"));

       seiko.addProduct(seiko5);
       seiko.addProduct(prospex);
       seiko.addProduct(presage);

       casio.addProduct(gshock);
       casio.addProduct(edifice);
    }



    public List<Brand> findAllBrands(){return new ArrayList<>(brands.values())  ;}
    public Brand findBrand(Long id){return brands.get(id);}

    public Brand saveBrand(Brand b){
        if(b.getId()==null) b.setId(brandSeq++);
        brands.put(b.getId(),b);
        return b;
    }

    public List<Product> findAllProducts(){return new ArrayList<>(products.values())  ;}
    public Product findProducts(Long id){return products.get(id);}

    public Product saveProducts(Product p){
        if(p.getId()==null) p.setId(prodSeq++);
        products.put(p.getId(),p);
        return p;
    }


}
