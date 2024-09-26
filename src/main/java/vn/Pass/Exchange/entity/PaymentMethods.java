package vn.Pass.Exchange.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment_methods")
public class PaymentMethods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_method_id", nullable = false)
    private Long paymentMethodId;

    @Column(name = "method_name", nullable = false, length = 50)
    private String methodName;

    @Column(name = "description", length = 255)
    private String description;


    @OneToMany(mappedBy = "paymentMethod")
    private Set<Transactions> transactions;
    
    // Constructors
    public PaymentMethods() {
    }

    public PaymentMethods(String methodName, String description) {
        this.methodName = methodName;
        this.description = description;
    }

    // Getters and Setters
    public Long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PaymentMethods{" +
                "paymentMethodId=" + paymentMethodId +
                ", methodName='" + methodName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
