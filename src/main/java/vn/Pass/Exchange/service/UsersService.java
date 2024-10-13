package vn.Pass.Exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.Pass.Exchange.DTO.UserDTO;
import vn.Pass.Exchange.Mapper.UserMapper;
import vn.Pass.Exchange.Request.SignupRequest;
import vn.Pass.Exchange.dao.AccountRepository;
import vn.Pass.Exchange.dao.AccountRoleMappingRepository;
import vn.Pass.Exchange.dao.RoleRepository;
import vn.Pass.Exchange.dao.UserRepository;
import vn.Pass.Exchange.entity.Account;
import vn.Pass.Exchange.entity.AccountRoleMapping;
import vn.Pass.Exchange.entity.Role;
import vn.Pass.Exchange.entity.User;

import java.time.LocalDateTime;

@Service
public class UsersService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserMapper userMapper;
    @Autowired
    AccountRoleMappingRepository accountRoleMappingRepository;
    @Autowired
    RoleRepository roleRepository;

    //Tạo user, accout, accountRoleMapping
    public UserDTO createUser(SignupRequest signupRequest) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pass = passwordEncoder.encode(signupRequest.getPassword());
        //Tạo account
        Account acc = new Account();
        acc.setUsername(signupRequest.getEmail());
        acc.setPassword(pass);
        acc.setEnabled(true);
        Account account = accountRepository.save(acc);
        //Role
        Role role = roleRepository.findById("USER")
                .orElseThrow(() -> new RuntimeException("Role not found"));
        //Mapping account vs role
        AccountRoleMapping accountRoleMapping = new AccountRoleMapping();
        accountRoleMapping.setAccount(account);
        accountRoleMapping.setRole(role);
        accountRoleMappingRepository.save(accountRoleMapping);
        //Tạo user
        User user = userRepository.save(new User(1L,
                signupRequest.getFirstname(),
                signupRequest.getLastname(),
                signupRequest.getCountry(),
                null,
                0L,
                null,
                LocalDateTime.now(), account)
        );
        return userMapper.toUserDTO(user);
    }


    public boolean checkEmail(String email) {
        if (accountRepository.findById(email).isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
