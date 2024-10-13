package vn.Pass.Exchange.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.Pass.Exchange.entity.User;

@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<User, Long> {
}
