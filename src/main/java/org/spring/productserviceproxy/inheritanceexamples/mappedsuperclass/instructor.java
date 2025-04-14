package org.spring.productserviceproxy.inheritanceexamples.mappedsuperclass;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "mps_instructor")
@Setter
@Getter

public class instructor extends User {
    private String company;


}
