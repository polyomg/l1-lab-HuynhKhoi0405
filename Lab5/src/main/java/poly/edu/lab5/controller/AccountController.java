package poly.edu.lab5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import poly.edu.lab5.service.CookieService;
import poly.edu.lab5.service.ParamService;
import poly.edu.lab5.service.SessionService;

import jakarta.annotation.Resource;

@Controller
public class AccountController {

    @Resource
    CookieService cookieService;

    @Resource
    ParamService paramService;

    @Resource
    SessionService sessionService;

    @GetMapping("/account/login")
    public String loginForm() {
        // Trả về view login.html (nằm trong /templates)
        return "login";
    }

    @PostMapping("/account/login")
    public String loginSubmit() {
        String username = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        boolean remember = paramService.getBoolean("remember", false);

        if (username.equals("poly") && password.equals("123")) {
            // Lưu username vào session
            sessionService.set("username", username);

            if (remember) {
                // Lưu cookie trong 10 ngày
                cookieService.add("user", username, 10 * 24);
            } else {
                cookieService.remove("user");
            }
        }
        return "login";
    }
}
