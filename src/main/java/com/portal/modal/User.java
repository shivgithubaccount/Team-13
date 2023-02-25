package com.portal.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import javax.persistence.*;

@Entity
@Table(name = "User")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 40)
    private String email;

    @Column(nullable = false, length = 10)
    private String password;

    @Column(nullable = false, length = 10)
    private Integer role;

    @Column(nullable = false)
    private Integer salary;

    @Column(nullable = false)
    private String name;

}
