package controller;

import data.ShopData;
import model.Brand;
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

    @GetMapping("/brands/{id}/products/add")
    public String addProductForm(@PathVariable Long id, Model model) {
        Brand brand = data.findBrand(id);
        if (brand == null) {
            return "redirect:/brands";
        }

        model.addAttribute("brand", brand);
        return "addProductToBrand";
    }
    @PostMapping("/brands/{id}/products/add")
    public String addProductToBrand(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam Integer price,
            @RequestParam String description
    ){
        Brand brand = data.findBrand(id);

        if (brand == null) {
            return "redirect:/brands";
        }

        Product product = data.saveProducts(new Product(null, name, price, description));
        brand.addProduct(product);

        return "redirect:/brands";
        }
}
