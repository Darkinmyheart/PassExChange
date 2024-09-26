package vn.Pass.Exchange.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.Pass.Exchange.entity.Users;

@RepositoryRestResource(path = "users")
public interface UsersDao extends JpaRepository<Users, String> {
	 Users findByUserName(String userName);
}
