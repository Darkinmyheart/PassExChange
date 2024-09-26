package vn.Pass.Exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.Pass.Exchange.entity.Users;
import vn.Pass.Exchange.service.TicketService;

@Controller
public class PageController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/postTicket")
    public String postTicket() {
        return "postTicket";
    }

    @GetMapping("/showSignupForm")
    public String showSignUpForm(Model model) {
        model.addAttribute("users", new Users());
        return "accounts";
    }

    @GetMapping("/ticketDetails")
    public String ticketDetails() {
        return "ticketDetails";
    }

    @GetMapping("/connectWallet")
    public String Connect() {
        return "connectWallet";
    }

    
}
