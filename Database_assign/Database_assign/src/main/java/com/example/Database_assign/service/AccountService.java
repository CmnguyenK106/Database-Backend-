package com.example.Database_assign.service;


import com.example.Database_assign.entities.Account;
import com.example.Database_assign.exception.DataValidationException;
import com.example.Database_assign.repository.AccountRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
    private final AccountRepo accountRepo;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public AccountService(AccountRepo accountRepo){
        this.accountRepo = accountRepo;
    }

    @Transactional
    public Integer addAccount(Account account){
//        StoredProcedureQuery query = em
//                .createStoredProcedureQuery("addAccount")
//                // position 1 is the RETURN value
//                .registerStoredProcedureParameter("Username", String.class, jakarta.persistence.ParameterMode.IN)
//                .registerStoredProcedureParameter("Password", String.class, jakarta.persistence.ParameterMode.IN)
//                .registerStoredProcedureParameter("Phone_number", Long.class, jakarta.persistence.ParameterMode.IN)
//                .registerStoredProcedureParameter("Email", String.class, jakarta.persistence.ParameterMode.IN)
//                .registerStoredProcedureParameter("First_name", String.class, jakarta.persistence.ParameterMode.IN)
//                .registerStoredProcedureParameter("Last_name", String.class, jakarta.persistence.ParameterMode.IN)
//                .registerStoredProcedureParameter("Role", String.class, jakarta.persistence.ParameterMode.IN)
//                .registerStoredProcedureParameter("return_value", int.class, jakarta.persistence.ParameterMode.OUT);
//
//        query.setParameter("Username", account.getUsername());
//        query.setParameter("Password", account.getPassword());
//        query.setParameter("Phone_number", account.getPhone_number());
//        query.setParameter("Email", account.getEmail());
//        query.setParameter("First_name", account.getFirst_name());
//        query.setParameter("Last_name", account.getLast_name());
//        query.setParameter("Role", account.getRole());
//
//        query.execute();
//
//        int resultCode = (int) query.getOutputParameterValue("return_value");
//        return resultCode;
//        int resultCode =  accountRepo.addAccount(
//                account.getUsername(),
//                account.getPassword(),
//                account.getPhone_number(),
//                account.getEmail(),
//                account.getFirst_name(),
//                account.getLast_name(),
//                account.getRole()
//        );
//        if (resultCode != 0) {
//            // map your error codes to messages as needed
//            throw new DataValidationException("Insert failed with code: " + resultCode);
//        }
        //return resultCode;
//        String procedureCall = "EXEC dbo.addAccount @Username = :username, " +
//                "@Password = :pass, @Phone_number = :Pnumb, @Email = :email, " +
//                "@First_name = :first, @Last_name = :last, @Role = :role";

        try{
                Integer result = (Integer) em
                    .createNativeQuery("DECLARE @ReturnValue INT; " +
                            "EXEC @ReturnValue = dbo.addAccount " +
                            "@Username = :username, " +
                            "@Password = :pass, " +
                            "@Phone_number = :Pnumb, " +
                            "@Email = :email, " +
                            "@First_name = :first, " +
                            "@Last_name = :last, " +
                            "@Role = :role; " +
                            "SELECT @ReturnValue")
                    .setParameter("username", account.getUsername())
                    .setParameter("pass", account.getPassword())
                    .setParameter("Pnumb", account.getPhone_number())
                    .setParameter("email", account.getEmail())
                    .setParameter("first", account.getFirst_name())
                    .setParameter("last", account.getLast_name())
                    .setParameter("role", account.getRole())
                    .getSingleResult();

            //return result_code;
            return result != null ? result : 0;
        } catch (Exception e) {
            // Extract error code from exception
            String message = e.getMessage();
            if (message != null) {
                if (message.contains("51001")) return 51001;
                if (message.contains("51002")) return 51002;
                if (message.contains("51003")) return 51003;
            }
            return -1;  // Generic error
        }
    }
}
