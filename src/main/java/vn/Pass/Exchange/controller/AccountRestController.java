package vn.Pass.Exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.Pass.Exchange.Request.SignupRequest;
import vn.Pass.Exchange.service.AccountService;
import vn.Pass.Exchange.service.UsersService;
import vn.Pass.Exchange.service.TicketService;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/account")
public class AccountRestController {

    @Autowired
    private UsersService userService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private TicketService ticketService;
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", Pattern.CASE_INSENSITIVE);
    private static final String PASSWORD_REGEX = "^(?=.*[!@#$%^&*()_+{}\\[\\]:;\"'\\\\|,.<>?`~\\-])(?=.*\\d)(?=.*[a-zA-Z]).{8,}$";

    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> signUp(@RequestBody SignupRequest registerRequest) {
        System.out.println(registerRequest);
        ResponseEntity<Map<String, String>> response;
        Map<String, String> map = new HashMap<String, String>();
        if (registerRequest.getPassword().isEmpty() ||
                registerRequest.getCountry().isEmpty() ||
                registerRequest.getFirstname().isEmpty() ||
                registerRequest.getEmail().isEmpty() ||
                registerRequest.getLastname().isEmpty()) { // Lỗi trống field
            map.put("status", "EMPTY FIELD");
        } else if (userService.checkEmail(registerRequest.getEmail())) { //Lỗi emaild đã được đky
            map.put("status", "DUPLICATED");
        } else if (!EMAIL_REGEX.matcher(registerRequest.getEmail().trim()).matches()) { //Lỗi định dạng email
            System.out.println(registerRequest.getEmail().trim());
            map.put("status", "ERROR EMAIL_REGEX");
        } else if (!registerRequest.getPassword().matches(PASSWORD_REGEX)) { //Lỗi định dạng password
            map.put("status", "ERROR PASSWORD_REGEX");
        }else {
            map.put("object",userService.createUser(registerRequest).toString());
            map.put("status", "COMPLETE");
        }
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        // Xóa session
        session.invalidate();
        // Xóa cookies (nếu có)
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("email".equals(cookie.getName()) || "password".equals(cookie.getName())) {
                    cookie.setValue("");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
        return "redirect:/signin";
    }
}
