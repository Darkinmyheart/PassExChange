package vn.Pass.Exchange.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.Pass.Exchange.entity.Account;

public interface AccountRepository extends JpaRepository<Account,String> {
}
