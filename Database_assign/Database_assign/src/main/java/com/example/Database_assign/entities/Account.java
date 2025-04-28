package com.example.Database_assign.entities;

//import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Account")
//@NamedStoredProcedureQuery(
//        name = "Account.addAccount",
//        procedureName = "InsertAccount",
//        parameters = {
//                @StoredProcedureParameter(mode = ParameterMode.IN,  name = "Username",   type = String.class),
//                @StoredProcedureParameter(mode = ParameterMode.IN,  name = "Password",   type = String.class),
//                @StoredProcedureParameter(mode = ParameterMode.IN,  name = "Phone_number",   type = Long.class),
//                @StoredProcedureParameter(mode = ParameterMode.IN,  name = "Email",   type = String.class),
//                @StoredProcedureParameter(mode = ParameterMode.IN,  name = "First_name",   type = String.class),
//                @StoredProcedureParameter(mode = ParameterMode.IN,  name = "Last_name",   type = String.class),
//                @StoredProcedureParameter(mode = ParameterMode.IN,  name = "Role",   type = String.class),
//                @StoredProcedureParameter(mode = ParameterMode.OUT,  name = "ResultCode",   type = int.class)
//        }
//)
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Account_ID",unique = true, nullable = false)
    private Long account_id;

    @Column(name = "Username", unique = true)
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Phone_number")
    private Long phone_number;

    @Column(name = "Email")
    private String email;

    @Column(name = "First_name")
    private String first_name;

    @Column(name = "Last_name")
    private String last_name;

    @Column(name = "Role")
    private String role;

//    public Account(Long account_id, String username, String password, Long phone_number, String email, String first_name, String last_name, String role) {
//        this.account_id = account_id;
//        this.username = username;
//        this.password = password;
//        this.phone_number = phone_number;
//        this.email = email;
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.role = role;
//    }

}
