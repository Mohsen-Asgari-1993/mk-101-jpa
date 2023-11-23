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
        name = Address.TABLE_NAME,
        indexes = {
                @Index(
                        name = "address_customer_id_index",
                        columnList = Address.CUSTOMER_ID
                )
        }
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity<Long> {

    public static final String TABLE_NAME = "address";

    public static final String ADDRESS = "address";
    public static final String POSTAL_CODE = "postal_code";
    public static final String CUSTOMER_ID = "customer_id";

    @Column(name = ADDRESS)
    private String address;

    @Column(name = POSTAL_CODE)
    private String postalCode;

    @Column(name = CUSTOMER_ID, nullable = false)
    private Long customerId;

}
