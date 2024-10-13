package vn.Pass.Exchange.Request;

import lombok.Data;

@Data
public class SignupRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String country;
    private String password;
}
