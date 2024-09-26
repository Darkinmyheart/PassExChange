//package vn.Pass.Exchange.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            // Cấu hình các yêu cầu bảo mật
//            .authorizeHttpRequests(authorize -> authorize
//                .requestMatchers("/", "/index", "/signin", "/signup").permitAll() // Cho phép truy cập không yêu cầu xác thực cho các trang này
//                .requestMatchers("/tickets/**").authenticated() // Yêu cầu xác thực cho các trang /tickets/** (thay đổi theo nhu cầu của bạn)
//                .anyRequest().authenticated() // Yêu cầu xác thực cho tất cả các yêu cầu còn lại
//            )
//            .formLogin(formLogin -> formLogin
//                .loginPage("/signin")
//                .permitAll()
//            )
//            .logout(logout -> logout
//                .permitAll()
//            );
//
//        // Vô hiệu hóa bộ nhớ đệm
//        http
//            .headers(headers -> headers
//                .cacheControl(cacheControl -> cacheControl.disable())
//                .addHeaderWriter((request, response) -> {
//                    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
//                    response.setHeader("Pragma", "no-cache");
//                    response.setDateHeader("Expires", 0);
//                })
//            );
//
//        return http.build();
//    }
//}
