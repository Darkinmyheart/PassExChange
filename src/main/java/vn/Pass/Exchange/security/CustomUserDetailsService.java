package vn.Pass.Exchange.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.Pass.Exchange.entity.Account;
import vn.Pass.Exchange.service.AccountService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final AccountService accountService; // Một service để lấy Account từ DB


    public CustomUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Lấy thông tin người dùng từ cơ sở dữ liệu
        Account account = accountService.findByUsername(username);

        // Nếu không tìm thấy tài khoản, ném ra ngoại lệ
        if (account == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // Trả về đối tượng CustomUserDetails được xây dựng từ Account
        return new CustomUserDetails(account);
    }
}
