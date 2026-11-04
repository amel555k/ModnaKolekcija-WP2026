package data;

import jakarta.annotation.PostConstruct;
import model.Brand;
import model.Category;
import model.Product;
import org.springframework.stereotype.Component;
import repository.BrandRepository;
import repository.CategoryRepository;
import repository.ProductRepository;

import java.util.List;

@Component
public class ShopData {

    private final BrandRepository brandRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ShopData(
            BrandRepository brandRepository,
            ProductRepository productRepository,
            CategoryRepository categoryRepository
    ) {
        this.brandRepository = brandRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostConstruct
    public void init() {
        if (brandRepository.count() > 0) {
            return;
        }

        Brand seiko = new Brand(null, "Seiko", "1881", 310);
        Brand casio = new Brand(null, "Casio", "1946", 290);

        Category classic = saveCategory(new Category(null, "Classic", "Klasični satovi"));
        Category sport = saveCategory(new Category(null, "Sport", "Sportski satovi"));
        Category luxury = saveCategory(new Category(null, "Luxury", "Luksuzni satovi"));
        Category digital = saveCategory(new Category(null, "Digital", "Digitalni satovi"));

        Product seiko5 = new Product(null, "5", 300, "Srebreni", classic);
        Product prospex = new Product(null, "Prospex", 610, "Crni mat", sport);
        Product presage = new Product(null, "Presage", 1200, "Najskuplji model", luxury);

        Product gshock = new Product(null, "GSHOCK", 300, "Zeleni camo", digital);
        Product edifice = new Product(null, "EDIFICE", 410, "Sportski", sport);

        seiko.addProduct(seiko5);
        seiko.addProduct(prospex);
        seiko.addProduct(presage);

        casio.addProduct(gshock);
        casio.addProduct(edifice);

        saveBrand(seiko);
        saveBrand(casio);
    }

    public List<Brand> findAllBrands() {
        return brandRepository.findAll();
    }

    public Brand findBrand(Long id) {
        return brandRepository.findById(id).orElse(null);
    }

    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findProducts(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProducts(Product product) {
        return productRepository.save(product);
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Category findCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
}