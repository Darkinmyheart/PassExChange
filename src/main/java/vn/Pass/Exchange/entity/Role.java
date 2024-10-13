package vn.Pass.Exchange.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "role")
    String role;
    @Column(name = "description")
    String description;
    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    Set<AccountRoleMapping> accountRoleMappings;
}
