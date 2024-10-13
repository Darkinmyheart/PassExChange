package vn.Pass.Exchange.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @OneToMany(mappedBy = "account",fetch = FetchType.EAGER)
    private Set<AccountRoleMapping> accountRoleMappings;

    @JsonIgnore
    @OneToOne(mappedBy = "account",fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY)
    private Set<Ticket> tickets;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<AccountRoleMapping> getAccountRoleMappings() {
        return accountRoleMappings;
    }

    public void setAccountRoleMappings(Set<AccountRoleMapping> accountRoleMappings) {
        this.accountRoleMappings = accountRoleMappings;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
