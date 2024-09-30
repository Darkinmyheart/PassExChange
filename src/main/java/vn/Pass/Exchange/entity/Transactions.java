package vn.Pass.Exchange.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data

@Table(name = "transaction")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactions_id", nullable = false)
    private Long transactionsId;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private Users users;

    @Column(name = "payment_methods", nullable = false, length = 50)
    private String paymentMethods;

    @Column(name = "transactions_hash", nullable = true, length = 255)
    private String transactionsHash;

    @Column(name = "bank_reference_number", nullable = true, length = 255)
    private String bankReferenceNumber;

    @Column(name = "transaction_date", nullable = false, updatable = false)
    private LocalDateTime transactionDate;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @OneToOne(mappedBy = "transactions", cascade = CascadeType.ALL, orphanRemoval = true)
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "ticket_id",nullable = false)
    private Ticket ticket;
}
