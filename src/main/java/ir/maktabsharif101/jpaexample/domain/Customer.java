package ir.maktabsharif101.jpaexample.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraphs(
        value = {
                @NamedEntityGraph(
                        name = Customer.ENTITY_GRAPH,
                        attributeNodes = {
                                @NamedAttributeNode(value = "roles", subgraph = "roles_subgraph")
                        },
                        subgraphs = {
                                @NamedSubgraph(
                                        name = "roles_subgraph",
                                        attributeNodes = {
                                                @NamedAttributeNode(
                                                        value = "permissions"
                                                ),
                                        }
                                )
                        }
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
