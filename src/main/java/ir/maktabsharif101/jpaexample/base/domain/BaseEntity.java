package ir.maktabsharif101.jpaexample.base.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity<ID extends Serializable> implements Serializable {

    public static final String ID = "id";

    @Id
    @GeneratedValue
    private ID id;

}
