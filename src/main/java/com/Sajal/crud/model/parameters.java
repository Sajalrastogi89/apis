package com.Sajal.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;


@Entity
public class parameters {

@NotEmpty(message="First name is not in correct form")
    private String First_name;

    private String Last_name;

    @Id@Email(message = "Email is not valid")
    private String Email;
   @NotEmpty(message="Format of password is not correct")
   @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message = "Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character:")
    private String password;

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
    }

    public String getEmail() {
        return Email;
    }


    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
