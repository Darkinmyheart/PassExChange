package vn.Pass.Exchange.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@Column(name = "username", nullable = false)
	private String userName;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "enabled", nullable = false)
	private Boolean enabled;

	@Column(name = "info_firstname", nullable = false, length = 50, columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
	private String firstName;

	@Column(name = "info_lastname", nullable = false, length = 50, columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
	private String lastName;

	@Column(name = "info_country", nullable = false, length = 50, columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
	private String country;

	@Column(name = "info_address", columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
	private String address;

	@Column(name = "info_phone", length = 15)
	private String phone;

	@Column(name = "info_avatar")
	private String avatar;

	@Column(name = "info_date", nullable = false)
	private Date createdDate;

	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Ticket> tickets;

	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Transactions> transactions;

	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<Invoice> invoices;

	// Constructors, getters, and setters

	public Users() {
	}

	public Users(String userName, String password, Boolean enabled, String firstName, String lastName, String country,
			Date createdDate) {
		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.createdDate = createdDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Users{" + "userName='" + userName + '\'' + ", password='" + password + '\'' + ", enabled=" + enabled
				+ ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", country='" + country + '\''
				+ ", address='" + address + '\'' + ", phone='" + phone + '\'' + ", avatar='" + avatar + '\''
				+ ", createdDate=" + createdDate + '}';
	}
	
}
