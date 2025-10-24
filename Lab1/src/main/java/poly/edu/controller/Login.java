package poly.edu.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class Login {
    @Autowired
    HttpServletRequest request;
    @RequestMapping("/form")
    public String form() {
        return "Dangnhap";
    }
    @RequestMapping("/check")
    public String login(Model model) {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        if ("khoi".equals(user) && "123".equals(pass)) {
            model.addAttribute("message", "Đăng nhập thành công!");
        } else {
            model.addAttribute("message", "Đăng nhập thất bại!");
        }
        return "Dangnhap";
    }
}
