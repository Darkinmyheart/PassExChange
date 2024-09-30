package vn.Pass.Exchange.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id", nullable = false)
    private Long ratingId;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "status_name", length = 50)
    private String statusName;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "transactions_id", referencedColumnName = "transactions_id", nullable = false)
    private Transactions transaction;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    private Users users;

    // Constructors

    public Rating() {
    }

    public Rating(int rating, String description, String statusName, Timestamp createdAt, Ticket ticket, Transactions transaction, Users users) {
        this.rating = rating;
        this.description = description;
        this.statusName = statusName;
        this.createdAt = createdAt;
        this.ticket = ticket;
        this.transaction = transaction;
        this.users = users;
    }

    // Getters and Setters

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Transactions getTransaction() {
        return transaction;
    }

    public void setTransaction(Transactions transaction) {
        this.transaction = transaction;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Raiting{" +
                "ratingId=" + ratingId +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", statusName='" + statusName + '\'' +
                ", createdAt=" + createdAt +
                ", ticket=" + ticket +
                ", transaction=" + transaction +
                ", users=" + users +
                '}';
    }
}
