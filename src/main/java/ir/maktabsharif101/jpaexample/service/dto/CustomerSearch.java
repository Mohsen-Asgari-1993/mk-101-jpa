package ir.maktabsharif101.jpaexample.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSearch implements Serializable {

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private ZonedDateTime fromDate;

    private ZonedDateTime toDate;

    private Boolean isActive;

    private String code;

}
