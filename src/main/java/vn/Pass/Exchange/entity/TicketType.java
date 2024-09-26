package vn.Pass.Exchange.entity;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "ticket_types")
public class TicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_type_id", nullable = false)
    private Long ticketTypeId;

    @Column(name = "ticket_type_name", nullable = false, length = 50)
    private String ticketTypeName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDate createdDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "ticketType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets;
    
    // Constructors, getters, and setters

    public TicketType() {
    }

    public TicketType(Long ticketTypeId, String ticketTypeName, String description, LocalDate endDate) {
        this.ticketTypeId = ticketTypeId;
        this.ticketTypeName = ticketTypeName;
        this.description = description;
        this.endDate = endDate;
    }

    // Getters and Setters

    public Long getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(Long ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public String getTicketTypeName() {
        return ticketTypeName;
    }

    public void setTicketTypeName(String ticketTypeName) {
        this.ticketTypeName = ticketTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDate.now();
    }
}
