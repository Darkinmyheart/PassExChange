package vn.Pass.Exchange.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import vn.Pass.Exchange.DTO.UserDTO;
import vn.Pass.Exchange.entity.User;

@Mapper(componentModel = "spring",unmappedSourcePolicy = ReportingPolicy.WARN, uses = AccountMapper.class)
public interface UserMapper {
    User toUser(UserDTO userDTO);
    UserDTO toUserDTO(User user);
}
