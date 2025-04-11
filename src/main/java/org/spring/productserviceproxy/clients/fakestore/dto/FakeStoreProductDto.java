package org.spring.productserviceproxy.clients.fakestore.dto;


import org.spring.productserviceproxy.clients.IClientProductDto;
import org.spring.productserviceproxy.dtos.RatingDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakeStoreProductDto implements IClientProductDto {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
    private RatingDto rating;
}