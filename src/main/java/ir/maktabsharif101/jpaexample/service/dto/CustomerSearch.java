package ir.maktabsharif101.jpaexample.service.dto;

import lombok.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerSearch implements Serializable {

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private ZonedDateTime fromDate;

    private ZonedDateTime toDate;

    private Boolean isActive;

    private String code;

}
