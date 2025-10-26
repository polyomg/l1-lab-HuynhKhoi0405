package poly.edu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/ctrl")
public class okcontroller {
    @RequestMapping("/ok")
    public String ok() {
        return "ok";
    }
    @PostMapping("/ok")
    public String m1(Model model) {
        model.addAttribute("message", "Phương thức m1() được gọi");
        return "ok";
    }
    @GetMapping("/ok")
    public String m2(Model model) {
        model.addAttribute("message", "Phương thức m2() được gọi");
        return "ok";
    }
    @RequestMapping(value = "/ok", params = "x")
    public String m3(Model model) {
        model.addAttribute("message", "Phương thức m3() được gọi");
        return "ok";
    }
}
