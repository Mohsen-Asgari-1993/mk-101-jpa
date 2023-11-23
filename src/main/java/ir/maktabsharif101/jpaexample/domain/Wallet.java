package ir.maktabsharif101.jpaexample.domain;

import ir.maktabsharif101.jpaexample.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(
        name = Wallet.TABLE_NAME,
        indexes = {
                @Index(
                        name = "wallet_customer_id_unique_index",
                        columnList = Wallet.CUSTOMER_ID,
                        unique = true
                )
        }
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Wallet extends BaseEntity<Long> {

    public static final String TABLE_NAME = "wallet";

    public static final String TOTAL_AMOUNT = "total_amount";
    public static final String CASH_AMOUNT = "cash_amount";
    public static final String CREDIT_AMOUNT = "credit_amount";
    public static final String CUSTOMER_ID = "customer_id";

    @Column(name = TOTAL_AMOUNT)
    private Long totalAmount = 0L;

    @Column(name = CASH_AMOUNT)
    private Long cashAmount = 0L;

    @Column(name = CREDIT_AMOUNT)
    private Long creditAmount = 0L;

    @Column(name = CUSTOMER_ID, nullable = false)
    private Long customerId;

    public Wallet(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + getId() +
                ", totalAmount=" + totalAmount +
                ", cashAmount=" + cashAmount +
                ", creditAmount=" + creditAmount +
                ", customerId=" + customerId +
                '}';
    }
}
