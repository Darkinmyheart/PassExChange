package vn.Pass.Exchange.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import vn.p.pet.dao.AuthoritiesDAO;
import vn.Pass.Exchange.dao.UsersDao;
//import vn.finder.pet.entity.Authorities;
import vn.Pass.Exchange.entity.Users;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UsersService {
	private UsersDao usersDAO;
	// private AuthoritiesDAO authoritiesDAO;

	@Autowired
	public UsersService(UsersDao usersDAO) {
		this.usersDAO = usersDAO;
		// this.authoritiesDAO = authoritiesDAO;
	}

	@Transactional
	public Users createdUser(Users users) {
		// Authorities authorities = new Authorities(users, "ROLE_USER");
		// authorities.setId(null);
		// this.authoritiesDAO.save(authorities);
		return this.usersDAO.save(users);
	}

	@Transactional
	public Optional<Users> findById(String username) {
		return this.usersDAO.findById(username);
	}

	public boolean isUserExists(String username) {
		return findById(username).isPresent();
	}

	@Transactional
	public Users saveUser(Users users) {
		return usersDAO.save(users);
	}

	public boolean isValidEmailAddress(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(emailRegex);
		return pattern.matcher(email).matches();
	}

	public boolean isValidPassword(String password) {
		// Kiểm tra độ dài mật khẩu
		if (password.length() < 8) {
			return false;
		}
		// Kiểm tra ít nhất 3 trong 4 điều kiện
		int conditionsMet = 0;
		if (password.matches(".*[a-z].*")) {
			conditionsMet++;
		}
		if (password.matches(".*[A-Z].*")) {
			conditionsMet++;
		}
		if (password.matches(".*\\d.*")) {
			conditionsMet++;
		}
		if (password.matches(".*[!@#$%^&*()-_=+\\\\|\\[{\\]};:'\",<.>/?].*")) {
			conditionsMet++;
		}
		return conditionsMet >= 3;
	}

	public Users authenticate(String userName, String password) {
		Users user = usersDAO.findByUserName(userName);
		if (user != null && user.getPassword().equals(password)) {
			return user; // Return user if credentials are correct
		}
		
		return null; // Return null if user not found or credentials are incorrect
	}

}
