package vn.Pass.Exchange.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reports")
public class Reports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id", nullable = false)
    private Long reportId;

    @Column(name = "reason", nullable = false, length = 50)
    private String reason;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "reply", columnDefinition = "TEXT")
    private String reply;

    @Column(name = "descriptions", columnDefinition = "TEXT")
    private String descriptions;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    private User user;

    // Constructors

    public Reports() {
    }

    public Reports(String reason, LocalDate createdAt, String reply, String descriptions, User user) {
        this.reason = reason;
        this.createdAt = createdAt;
        this.reply = reply;
        this.descriptions = descriptions;
        this.user = user;
    }

    // Getters and Setters

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Reports{" +
                "reportId=" + reportId +
                ", reason='" + reason + '\'' +
                ", createdAt=" + createdAt +
                ", reply='" + reply + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", user=" + user +
                '}';
    }
}
