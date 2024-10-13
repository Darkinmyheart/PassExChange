package vn.Pass.Exchange.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import vn.Pass.Exchange.DTO.AccountDTO;
import vn.Pass.Exchange.entity.Account;

@Mapper(componentModel = "spring",uses = UserMapper.class)
public interface AccountMapper {
    Account toAccount(AccountDTO accountDTO);
    AccountDTO toAccountDTO(Account account);
}
