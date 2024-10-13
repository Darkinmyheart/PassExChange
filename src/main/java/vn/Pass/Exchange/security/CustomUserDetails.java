package vn.Pass.Exchange.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vn.Pass.Exchange.entity.Account;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {
    private final Account account;

    public CustomUserDetails(Account account) {
        this.account = account;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return account
                .getAccountRoleMappings().stream()
                .map(mapping -> (GrantedAuthority) () -> mapping.getRole().getRole())
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getUsername();
    }

    public String getFullname() {
        return account.getUser().getFirstName()+account.getUser().getLastName();  // Lấy firstname từ User
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return account.getEnabled();
    }
}
