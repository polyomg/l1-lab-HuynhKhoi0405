package poly.edu.lab5.service;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CookieService {
    @jakarta.annotation.Resource
    HttpServletRequest request;
    @jakarta.annotation.Resource
    HttpServletResponse response;
    public Cookie get(String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie c : cookies)
                if (c.getName().equals(name)) return c;
        return null;
    }
    public String getValue(String name) {
        Cookie c = get(name);
        return c != null ? c.getValue() : "";
    }
    public Cookie add(String name, String value, int hours) {
        Cookie c = new Cookie(name, value);
        c.setPath("/");
        c.setMaxAge(hours * 3600);
        response.addCookie(c);
        return c;
    }
    public void remove(String name) {
        add(name, "", 0);
    }
}
