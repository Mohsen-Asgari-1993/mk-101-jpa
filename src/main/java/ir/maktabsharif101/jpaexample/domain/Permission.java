package ir.maktabsharif101.jpaexample.domain;

import ir.maktabsharif101.jpaexample.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Permission.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Permission extends BaseEntity<Long> {

    public static final String TABLE_NAME = "permissions";

    public static final String NAME = "name";

    @Column(name = NAME)
    private String name;

}
