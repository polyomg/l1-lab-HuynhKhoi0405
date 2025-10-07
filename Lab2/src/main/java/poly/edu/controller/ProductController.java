package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.model.Product;

@Controller
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product p) {
        return "product";
    }
}
