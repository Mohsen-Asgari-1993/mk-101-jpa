package ir.maktabsharif101.jpaexample.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends BaseUser {

    public static final String TABLE_NAME = "tbl_users";

    public static final String IS_SUPER_ADMIN = "is_super_admin";

    @Column(name = IS_SUPER_ADMIN)
    private Boolean isSuperAdmin;

}
