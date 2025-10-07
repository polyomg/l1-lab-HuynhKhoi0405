package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.model.Product;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product2")
public class ProductController2 {
    private final List<Product> items = new ArrayList<>();
    public ProductController2() {
        items.add(new Product("A", 1.0));
        items.add(new Product("B", 2.0));
        items.add(new Product("C", 3.0));
    }
    @GetMapping("/form")
    public String form(Model model) {
        Product p = new Product();
        p.setName("iPhone 50");
        p.setPrice(3000.0);
        model.addAttribute("product", p);
        return "product2";
    }

    /*Huỳnh Gia Khôi TV00120*/
    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product p, Model model) {
        items.add(p);
        model.addAttribute("lastProduct", p);

        return "product2";
    }
    @ModelAttribute("items")
    public List<Product> getItems() {
        return items;
    }
}
