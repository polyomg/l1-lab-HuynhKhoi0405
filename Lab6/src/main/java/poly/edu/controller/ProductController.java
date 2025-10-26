package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.dao.ProductDAO;
import poly.edu.model.Product;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    ProductDAO dao;

    // Sắp xếp
    @RequestMapping("/product/sort")
    public String sort(Model model, @RequestParam("field") Optional<String> field) {
        String sortField = field.orElse("price");
        Sort sort = Sort.by(Sort.Direction.DESC, sortField);
        model.addAttribute("field", sortField.toUpperCase());
        List<Product> items = dao.findAll(sort);
        model.addAttribute("items", items);
        return "product/sort";
    }
    // Phân trang
        @RequestMapping("/product/page")
        public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
            int pageIndex = Math.max(0, p.orElse(0));
            PageRequest pageable = PageRequest.of(pageIndex, 5);
            Page<Product> page = dao.findAll(pageable);
            model.addAttribute("page", page);
            return "product/page";
        }
}
