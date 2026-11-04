package spring_boot_security.product.infrastructure.api.dto;

import lombok.Data;

import java.util.List;


@Data
//This is the information that arrive to our input of APIRest
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String image;
    private String provider;
    private List<ReviewDto> reviews;
    private List<String> categories;

}
