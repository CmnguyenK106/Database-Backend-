package com.example.Database_assign.repository;

import com.example.Database_assign.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
//    @Procedure(procedureName = "dbo.addAccount", outputParameterName = "result")
//    int addAccount(
//            @Param("Username") String username,
//            @Param("Password") String password,
//            @Param("Phone_number") Long phone_number,
//            @Param("Email") String email,
//            @Param("First_name") String first_name,
//            @Param("Last_name") String last_name,
//            @Param("Role") String role
//    );
}
