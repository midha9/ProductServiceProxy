package org.spring.productserviceproxy.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Categories extends BaseModel {

    private String name;
    private String description;
    private List<Product> productList;

}
