package ir.maktabsharif101.jpaexample.domain;

import ir.maktabsharif101.jpaexample.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
@NamedEntityGraphs(
        value = {
                @NamedEntityGraph(
                        name = Wallet.ENTITY_GRAPH,
                        attributeNodes = {
                                @NamedAttributeNode(value = "customer")
                        }
                )
        }
)
public class Wallet extends BaseEntity<Long> {

    public static final String TABLE_NAME = "wallet";

    public static final String ENTITY_GRAPH = "wallet_entity_graph";

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

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = CUSTOMER_ID)
    private Customer customer;

    public Wallet(Long customerId) {
        Customer customer = new Customer();
        customer.setId(customerId);
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + getId() +
                ", totalAmount=" + totalAmount +
                ", cashAmount=" + cashAmount +
                ", creditAmount=" + creditAmount +
//                ", customerId=" + customerId +
                ", customer=" + customer +
                '}';
    }
}
