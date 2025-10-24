package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hcn")
public class TinhHinhChuNhat {
    @RequestMapping("/form")
    public String form() {
        return "hinhchunhat";
    }
    @RequestMapping("/tinh")
    public String tinh(double dai, double rong, Model model) {
        double dientich = dai * rong;
        double chuvi = (dai + rong) * 2;
        model.addAttribute("dientich", dientich);
        model.addAttribute("chuvi", chuvi);
        return "hinhchunhat";
    }
}
