package vn.Pass.Exchange.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.Pass.Exchange.entity.Role;

public interface RoleRepository extends JpaRepository<Role,String> {
}
