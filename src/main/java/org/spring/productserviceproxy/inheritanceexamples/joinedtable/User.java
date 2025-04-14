package org.spring.productserviceproxy.inheritanceexamples.joinedtable;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "jt_user")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
}
