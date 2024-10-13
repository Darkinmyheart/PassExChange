package vn.Pass.Exchange.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "transactiondetail")
public class TransactionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;
    @OneToOne
    @JoinColumn(name = "ticket_id",nullable = false)
    Ticket ticket;
    @OneToOne
    @JoinColumn(name = "transaction_id",nullable = false)
    Transactions transactions;
}
