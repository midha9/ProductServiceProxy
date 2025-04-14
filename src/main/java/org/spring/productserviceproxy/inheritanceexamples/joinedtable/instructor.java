package org.spring.productserviceproxy.inheritanceexamples.joinedtable;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "jt_instructor")
@Setter
@Getter
@PrimaryKeyJoinColumn(name = "user_id")

public class instructor extends User {
    private String company;


}
