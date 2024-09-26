package vn.Pass.Exchange.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
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
    @JoinColumn(name = "transactions_id", referencedColumnName = "transactions_id", nullable = false)
    private Transactions transactions;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private Users users;

    // Constructors, getters, and setters

    public Invoice() {
    }

    public Invoice(BigDecimal amount, String status, String descriptions, LocalDate invoiceDate, LocalDate createdDate) {
        this.amount = amount;
        this.status = status;
        this.descriptions = descriptions;
        this.invoiceDate = invoiceDate;
        this.createdDate = createdDate;
    }

    // Getters and Setters
    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Transactions getTransactions() {
        return transactions;
    }

    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", createdDate=" + createdDate +
                '}';
    }
}
