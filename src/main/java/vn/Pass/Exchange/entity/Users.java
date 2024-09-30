package vn.Pass.Exchange.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "user")
public class Users {

	@Id
	@Column(name = "id", nullable = false)
	private String id;

	@Column(name = "firstname", nullable = false, length = 50, columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
	private String firstName;

	@Column(name = "lastname", nullable = false, length = 50, columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
	private String lastName;

	@Column(name = "address", columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
	private String address;

	@Column(name = "phone", length = 15)
	private String phone;

	@Column(name = "coin_balance")
	private Long coin;

	@Column(name = "avatar")
	private String avatar;

	@Column(name = "createdDate", nullable = false)
	private Date createdDate;

	@OneToOne
	@JoinColumn(name = "username",nullable = false)
	private Account account;
}
