package vn.Pass.Exchange.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.Pass.Exchange.entity.AccountRoleMapping;

public interface AccountRoleMappingRepository extends JpaRepository<AccountRoleMapping,Long> {
}
