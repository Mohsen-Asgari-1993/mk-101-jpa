package ir.maktabsharif101.jpaexample.domain;

import ir.maktabsharif101.jpaexample.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = BaseUser.TABLE_NAME,
        indexes = {
                @Index(
                        name = "users_username_index", columnList = BaseUser.USERNAME
                )
        }
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseUser extends BaseEntity<Long> {

    public static final String TABLE_NAME = "tbl_users";

    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String CREATE_DATE = "create_date";
    public static final String LAST_UPDATE_DATE = "last_update_date";
    public static final String NATIONAL_CODE = "national_code";
    public static final String MOBILE_NUMBER = "mobile_number";
    public static final String IS_ACTIVE = "is_active";
    public static final String USERS_ROLES_JOIN_TABLE = "users_roles";

    @Column(name = FIRST_NAME)
    private String firstName;

    @Column(name = LAST_NAME)
    private String lastName;

    @Column(name = USERNAME, nullable = false)
    private String username;

    @Column(name = PASSWORD, nullable = false)
    private String password;

    @Column(name = CREATE_DATE)
    private ZonedDateTime createDate = ZonedDateTime.now();

    @Column(name = LAST_UPDATE_DATE)
    private ZonedDateTime lastUpdateDate = ZonedDateTime.now();

    @Column(name = NATIONAL_CODE)
    private String nationalCode;

    @Column(name = MOBILE_NUMBER)
    private String mobileNumber;

    @Column(name = IS_ACTIVE)
    private Boolean isActive = true;

    @ManyToMany
    @JoinTable(name = USERS_ROLES_JOIN_TABLE)
    private Set<Role> roles = new HashSet<>();

}
