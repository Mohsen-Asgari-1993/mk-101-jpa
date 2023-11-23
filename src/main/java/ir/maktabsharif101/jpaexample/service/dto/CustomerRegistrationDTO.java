package ir.maktabsharif101.jpaexample.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegistrationDTO implements Serializable {

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private String password;

}
