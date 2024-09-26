//package vn.Pass.Exchange.entity;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "authorities")
//public class Authorities {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "authorities_id", nullable = false)
//    private Long authoritiesId;
//
//    @Column(name = "username", nullable = false, length = 50, columnDefinition = "NVARCHAR(50)")
//    private String username;
//
//    @Column(name = "authority", nullable = false, length = 20)
//    private String authority;
//
//    // Constructors, getters và setters
//
//    public Authorities() {
//    }
//
//    public Authorities(String username, String authority) {
//        this.username = username;
//        this.authority = authority;
//    }
//
//    public Long getAuthoritiesId() {
//        return authoritiesId;
//    }
//
//    public void setAuthoritiesId(Long authoritiesId) {
//        this.authoritiesId = authoritiesId;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getAuthority() {
//        return authority;
//    }
//
//    public void setAuthority(String authority) {
//        this.authority = authority;
//    }
//}
