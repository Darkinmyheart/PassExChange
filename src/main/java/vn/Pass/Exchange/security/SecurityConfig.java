package vn.Pass.Exchange.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final CustomUserDetailsService customUserDetailsService;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                // Cấu hình các yêu cầu bảo mật
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/account/signup", "/index").permitAll() // Cho phép truy cập không yêu cầu xác thực cho các trang này
                        .requestMatchers("/tickets/**").hasAnyAuthority("ADMIN", "USER")// Yêu cầu xác thực cho các trang /tickets/** (thay đổi theo nhu cầu của bạn)
                        .requestMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/scss/**").permitAll() // Cho phép truy cập không yêu cầu xác thực cho các file tĩnh
                        .anyRequest().authenticated() // Yêu cầu xác thực cho tất cả các yêu cầu còn lại
                )
                .formLogin(formLogin -> formLogin
                                .loginPage("/signin")
                                .loginProcessingUrl("/login")
                                .failureUrl("/signin?error=true")
                                .defaultSuccessUrl("/index", true)
                                .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/index")
                        .permitAll()
                )
                .userDetailsService(customUserDetailsService)
        ;

        // Vô hiệu hóa bộ nhớ đệm
        http
                .headers(headers -> headers
                        .cacheControl(cacheControl -> cacheControl.disable())
                        .addHeaderWriter((request, response) -> {
                            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
                            response.setHeader("Pragma", "no-cache");
                            response.setDateHeader("Expires", 0);
                        })
                );
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
