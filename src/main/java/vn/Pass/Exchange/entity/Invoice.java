package vn.Pass.Exchange.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id", nullable = false)
    private Long invoiceId;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "descriptions", length = 255)
    private String descriptions;

    @Column(name = "invoice_date", nullable = false)
    private LocalDate invoiceDate;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @OneToOne
    @JoinColumn(name = "transactions_id", nullable = false)
    private Transactions transactions;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private Users users;
}
