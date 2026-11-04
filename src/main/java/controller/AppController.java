package controller;

import data.ShopData;
import model.Brand;
import model.Category;
import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

    private final ShopData data;

    public AppController(ShopData data) {
        this.data = data;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/brands";
    }

    @GetMapping("/brands")
    public String brands(Model model) {
        model.addAttribute("brands", data.findAllBrands());
        return "listBrands";
    }

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("products", data.findAllProducts());
        return "listProducts";
    }

    @GetMapping("/categories")
    public String categories(Model model) {
        model.addAttribute("categories", data.findAllCategories());
        return "listCategories";
    }

    @GetMapping("/categories/add")
    public String addCategoryForm() {
        return "addCategory";
    }

    @PostMapping("/categories/add")
    public String addCategory(
            @RequestParam String name,
            @RequestParam String description
    ) {
        data.saveCategory(new Category(null, name, description));
        return "redirect:/categories";
    }

    @GetMapping("/categories/edit/{id}")
    public String editCategoryForm(@PathVariable Long id, Model model) {
        Category category = data.findCategory(id);

        if (category == null) {
            return "redirect:/categories";
        }

        model.addAttribute("category", category);
        return "editCategory";
    }

    @PostMapping("/categories/update/{id}")
    public String updateCategory(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String description
    ) {
        Category category = data.findCategory(id);

        if (category == null) {
            return "redirect:/categories";
        }

        category.setName(name);
        category.setDescription(description);

        data.saveCategory(category);

        return "redirect:/categories";
    }

    @GetMapping("/brands/{id}/products/add")
    public String addProductForm(@PathVariable Long id, Model model) {
        Brand brand = data.findBrand(id);

        if (brand == null) {
            return "redirect:/brands";
        }

        model.addAttribute("brand", brand);
        model.addAttribute("categories", data.findAllCategories());
        return "addProductToBrand";
    }

    @PostMapping("/brands/{id}/products/add")
    public String addProductToBrand(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam Integer price,
            @RequestParam String description,
            @RequestParam Long categoryId
    ) {
        Brand brand = data.findBrand(id);
        Category category = data.findCategory(categoryId);

        if (brand == null || category == null) {
            return "redirect:/brands";
        }

        Product product = new Product(null, name, price, description, category);
        brand.addProduct(product);

        data.saveBrand(brand);

        return "redirect:/brands";
    }
}