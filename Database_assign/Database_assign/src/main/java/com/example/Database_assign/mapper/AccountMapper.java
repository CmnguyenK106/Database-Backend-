package com.example.Database_assign.mapper;

import com.example.Database_assign.dto.AccountDto;
import com.example.Database_assign.entities.Account;

public class AccountMapper {

    public static AccountDto mapToAccountDto(Account account){
        return new AccountDto(
                account.getAccount_id(),
                account.getUsername(),
                account.getPassword(),
                account.getPhone_number(),
                account.getEmail(),
                account.getFirst_name(),
                account.getLast_name(),
                account.getRole()
        );
    }

    public static Account mapToAccount(AccountDto dto){
        return new Account(
                dto.getAccount_id(),
                dto.getUsername(),
                dto.getPasswd(),
                dto.getPhone_number(),
                dto.getEmail(),
                dto.getFirst_name(),
                dto.getLast_name(),
                dto.getRole()
        );
    }
}
