package org.spring.productserviceproxy.models;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private boolean isDeleted;
}