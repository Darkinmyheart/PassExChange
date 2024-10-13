package vn.Pass.Exchange.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ticket_name", nullable = false, length = 50, columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String ticketName;

    @Column(name = "event_name", nullable = false, length = 255, columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String eventName;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "startedDate", nullable = false)
    private LocalDate startedDate;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

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

    @Column(name = "createdDate", nullable = false, updatable = false)
    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "ticket_type_id", nullable = false)
    private TicketType ticketType;

    @OneToMany(mappedBy = "ticket",fetch = FetchType.LAZY)
    private Set<Transactions> transactions;

    @OneToMany(mappedBy = "ticket",fetch = FetchType.LAZY)
    private Set<Rating> Ratings;
    
}
