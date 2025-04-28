package com.example.Database_assign.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long account_id;
    private String username;
    private String passwd;
    private Long phone_number;
    private String email;
    private String first_name;
    private String last_name;
    private String role;
}
