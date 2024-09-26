package vn.Pass.Exchange.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transactions")
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

    @ManyToMany
    @JoinTable(name = "transactions_tickets",
               joinColumns = @JoinColumn(name = "transactions_id"),
               inverseJoinColumns = @JoinColumn(name = "ticket_id"))
    private List<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "payment_method_id", nullable = false)
    private PaymentMethods paymentMethod;

    @PrePersist
    protected void onCreate() {
        if (this.transactionDate == null) {
            this.transactionDate = LocalDateTime.now();
        }
    }

    // Constructors, getters, and setters

    public Transactions() {
    }

    public Transactions(Users users, String paymentMethods, String transactionsHash, String bankReferenceNumber,
                        LocalDateTime transactionDate, String status) {
        this.users = users;
        this.paymentMethods = paymentMethods;
        this.transactionsHash = transactionsHash;
        this.bankReferenceNumber = bankReferenceNumber;
        this.transactionDate = transactionDate;
        this.status = status;
    }

    // Getters and Setters
    public Long getTransactionsId() {
        return transactionsId;
    }

    public void setTransactionsId(Long transactionsId) {
        this.transactionsId = transactionsId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(String paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public String getTransactionsHash() {
        return transactionsHash;
    }

    public void setTransactionsHash(String transactionsHash) {
        this.transactionsHash = transactionsHash;
    }

    public String getBankReferenceNumber() {
        return bankReferenceNumber;
    }

    public void setBankReferenceNumber(String bankReferenceNumber) {
        this.bankReferenceNumber = bankReferenceNumber;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public PaymentMethods getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethods paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "transactionsId=" + transactionsId +
                ", users=" + users +
                ", paymentMethods='" + paymentMethods + '\'' +
                ", transactionsHash='" + transactionsHash + '\'' +
                ", bankReferenceNumber='" + bankReferenceNumber + '\'' +
                ", transactionDate=" + transactionDate +
                ", status='" + status + '\'' +
                '}';
    }
}
