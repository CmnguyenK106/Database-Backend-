package com.example.Database_assign.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("CUSTOMER")
public class Customer extends Account{

    @Column(name = "Address")
    private String address;

    public Customer(Long account_id, String username, String password, Long phone_number, String email, String first_name, String last_name, String role, String address){
        super(account_id, username, password, phone_number, email, first_name, last_name, role);
        this.address = address;
    }

    Long getCustomer_id(){
        return getAccount_id();
    }

    @Column(name = "Cart_ID")
    private Long Cart_ID;

}
