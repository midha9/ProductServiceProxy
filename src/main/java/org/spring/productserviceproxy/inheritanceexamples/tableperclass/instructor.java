package org.spring.productserviceproxy.inheritanceexamples.tableperclass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "tpc_instructor")
@Setter
@Getter
public class instructor extends User {
    private String company;


}
