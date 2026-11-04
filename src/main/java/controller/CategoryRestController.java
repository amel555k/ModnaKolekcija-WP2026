package controller;

import data.ShopData;
import model.Category;
import model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryRestController {

    private final ShopData data;

    public CategoryRestController(ShopData data) {
        this.data = data;
    }

    @GetMapping("/api/categories")
    public List<CategoryResponse> getCategories() {
        List<CategoryResponse> responses = new ArrayList<>();

        for (Category category : data.findAllCategories()) {
            responses.add(toCategoryResponse(category));
        }

        return responses;
    }

    @GetMapping("/api/categories/{id}")
    public CategoryResponse getCategoryById(@PathVariable Long id) {
        Category category = data.findCategory(id);

        if (category == null) {
            return null;
        }

        return toCategoryResponse(category);
    }

    private CategoryResponse toCategoryResponse(Category category) {
        List<ProductResponse> products = new ArrayList<>();

        for (Product product : category.getProducts()) {
            products.add(toProductResponse(product));
        }

        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription(),
                products
        );
    }

    private ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDescription()
        );
    }

    public record CategoryResponse(
            Long id,
            String name,
            String description,
            List<ProductResponse> products
    ) {
    }

    public record ProductResponse(
            Long id,
            String name,
            Integer price,
            String description
    ) {
    }
}