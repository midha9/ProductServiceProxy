package org.spring.productserviceproxy.inheritanceexamples.singleclass;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "sc_instructor")
@Setter
@Getter
@DiscriminatorValue(value = "3")
public class instructor extends User {
    private String company;


}
