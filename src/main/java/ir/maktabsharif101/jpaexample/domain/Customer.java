package ir.maktabsharif101.jpaexample.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraphs(
        value = {
                @NamedEntityGraph(
                        name = Customer.ENTITY_GRAPH
//                        TODO complete this
                )
        }
)
public class Customer extends BaseUser {

    public static final String ENTITY_GRAPH = "customerEntityGraph";

    public static final String CODE = "code";

    @Column(name = CODE, unique = true, nullable = false)
    private String code;

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + getId() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", mobileNumber='" + getMobileNumber() + '\'' +
                '}';
    }
}
