package vn.Pass.Exchange.controller;
import java.sql.Date;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.Pass.Exchange.entity.Users;
import vn.Pass.Exchange.service.UsersService;
import vn.Pass.Exchange.service.TicketService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private UsersService userService;

	@Autowired
	private TicketService ticketService;

//	@PostMapping("/signup")
//	public String signUp(@ModelAttribute("users") Users users, @RequestParam("cfPassword") String cfPassword,
//			RedirectAttributes redirectAtb) {
//		try {
//			Date createdDate = new Date(Calendar.getInstance().getTime().getTime());
//			users.setCreatedDate(createdDate);
//			users.setEnabled(false);
//			userService.saveUser(users);
//			return "redirect:/index";
//		} catch (Exception e) {
//			redirectAtb.addFlashAttribute("errorMessage", "Có lỗi xảy ra khi đăng ký tài khoản");
//			return "redirect:/signup";
//		}
//	}


//
//	@PostMapping("/signin")
//	public String signInProcess(@Validated Users user, BindingResult bindingResult, HttpSession session,
//			HttpServletRequest request, HttpServletResponse response, Model model) {
//		if (bindingResult.hasErrors()) {
//			return "signin";
//		}
//		Users loggedInUser = userService.authenticate(user.getUserName(), user.getPassword());
//		if (loggedInUser != null) {
//			session.setAttribute("loggedInUser", loggedInUser);
//			model.addAttribute("loggedInUser", loggedInUser);
//
//			// Xử lý ghi nhớ mật khẩu
//			if ("on".equals(request.getParameter("remember_me"))) {
//				// Tạo cookie để lưu thông tin đăng nhập
//				Cookie emailCookie = new Cookie("email", user.getUserName());
//				Cookie passCookie = new Cookie("password", user.getPassword());
//
//				emailCookie.setMaxAge(30 * 24 * 60 * 60); // 30 days
//				passCookie.setMaxAge(30 * 24 * 60 * 60); // 30 days
//
//				// Thêm cookie vào response
//				response.addCookie(emailCookie);
//				response.addCookie(passCookie);
//			} else {
//				Cookie[] cookies = request.getCookies();
//				if (cookies != null) {
//					for (Cookie cookie : cookies) {
//						if ("email".equals(cookie.getName()) || "password".equals(cookie.getName())) {
//							cookie.setValue("");
//							cookie.setMaxAge(0);
//							response.addCookie(cookie);
//						}
//					}
//				}
//			}
//
//			return "redirect:/index";
//		} else {
//			model.addAttribute("error", "Invalid Password or Email!!");
//			return "signin";
//		}
//	}

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
