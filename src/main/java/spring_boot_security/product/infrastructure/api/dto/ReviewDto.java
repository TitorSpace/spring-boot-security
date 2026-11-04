package spring_boot_security.product.infrastructure.api.dto;

import lombok.Data;

@Data
public class ReviewDto {

    private Long id;
    private String comment;
    private String score;

}
