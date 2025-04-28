package com.example.Database_assign.entities;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@DiscriminatorValue("ADMIN")
public class Admin extends Account{

    @Column(name = "SuperAdmin_ID")
    private Long super_admin_id;

    public Admin(Long account_id, String username, String password, Long phone_number, String email, String first_name, String last_name, String role, Long super_admin_id){
        super(account_id, username, password, phone_number, email, first_name, last_name, role);
        this.super_admin_id = super_admin_id;
    }

    Long getSuperAdminID(){
        return super_admin_id;
    }
}
