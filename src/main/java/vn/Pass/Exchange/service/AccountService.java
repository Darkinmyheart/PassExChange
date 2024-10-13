package vn.Pass.Exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.Pass.Exchange.dao.AccountRepository;
import vn.Pass.Exchange.dao.UserRepository;
import vn.Pass.Exchange.entity.Account;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserRepository userRepository;
    @Transactional
    public Account findByUsername(String username){
       return accountRepository.findById(username).orElse(null);
    }
}
