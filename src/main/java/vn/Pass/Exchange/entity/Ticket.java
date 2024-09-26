package vn.Pass.Exchange.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id", nullable = false)
    private Long ticketId;

    @Column(name = "ticket_name", nullable = false, length = 50, columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String ticketName;

    @Column(name = "event_name", nullable = false, length = 255, columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String eventName;

    @Column(name = "ticket_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal ticketPrice;

    @Column(name = "ticket_date", nullable = false)
    private LocalDate ticketDate;

    @Column(name = "ticket_img", nullable = false)
    private String ticketImg;

    @Column(name = "status_name", nullable = false, length = 50)
    private String statusName;

    @Column(name = "qr_code", nullable = false)
    private byte[] qrCode;

    @Column(name = "description", columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String description;

    @Column(name = "location", nullable = false, length = 100, columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String location;

    @Column(name = "district", nullable = false, length = 50, columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String district;

    @Column(name = "address", nullable = false, length = 50, columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String address;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "ticket_type_id", nullable = false)
    private TicketType ticketType;

    @ManyToMany(mappedBy = "tickets")
    private List<Transactions> transactions;

    // Constructors, getters and setters

    public Ticket() {
    }

    public Ticket(Long ticketId, String ticketName, String eventName, BigDecimal ticketPrice, LocalDate ticketDate,
                  String statusName, byte[] qrCode, Users users, String description, String location,
                  String district, String address, LocalDate createdDate, String ticketImg) {
        this.ticketId = ticketId;
        this.ticketName = ticketName;
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
        this.ticketDate = ticketDate;
        this.statusName = statusName;
        this.qrCode = qrCode;
        this.users = users;
        this.description = description;
        this.location = location;
        this.district = district;
        this.address = address;
        this.createdDate = createdDate;
        this.ticketImg = ticketImg;
    }

    // Getters and Setters

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public LocalDate getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(LocalDate ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getTicketImg() {
        return ticketImg;
    }

    public void setTicketImg(String ticketImg) {
        this.ticketImg = ticketImg;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public byte[] getQrCode() {
        return qrCode;
    }

    public void setQrCode(byte[] qrCode) {
        this.qrCode = qrCode;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Ticket [ticketId=" + ticketId + ", ticketName=" + ticketName + ", eventName=" + eventName
                + ", ticketPrice=" + ticketPrice + ", ticketDate=" + ticketDate + ", ticketImg=" + ticketImg
                + ", statusName=" + statusName + ", qrCode=" + Arrays.toString(qrCode) + ", description=" + description
                + ", location=" + location + ", district=" + district + ", address=" + address + ", createdDate="
                + createdDate + ", users=" + users + ", ticketType=" + ticketType + ", transactions=" + transactions
                + "]";
    }
    
}
