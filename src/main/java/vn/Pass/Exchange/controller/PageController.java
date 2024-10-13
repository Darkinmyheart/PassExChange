package vn.Pass.Exchange.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.Pass.Exchange.entity.User;
import vn.Pass.Exchange.service.TicketService;

@Controller
public class PageController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/postTicket")
    public String postTicket() {
        return "postTicket";
    }

    @GetMapping("/signin")
    public String showSignInForm(Model model) {
        return "acount";
    }

    @GetMapping("/ticketDetails")
    public String ticketDetails() {
        return "ticketDetails";
    }

    @GetMapping("/connectWallet")
    public String Connect() {
        return "connectWallet";
    }

    @GetMapping("/index")
    public String showIndex(Model model, HttpSession session) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Đổ dữ liệu từ ticketService
        model.addAttribute("tickets", ticketService.getAllTickets());
        // Kiểm tra xem có người dùng nào đã đăng nhập hay chưa
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("loggedInUser", loggedInUser);
        }
        return "index";
    }

    @GetMapping("/signup")
    public String regis() {
        return "acount";

    }
//
//    @GetMapping("/register")
//    public String showSignUpForm(Model model) {
//        model.addAttribute("users", new Users());
//        return "signup";
//    }
}
