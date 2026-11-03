package spring_boot_web_jpa.product.application.command.update;

import lombok.Data;
import spring_boot_web_jpa.common.application.mediator.Request;
import spring_boot_web_jpa.review.domain.Review;

@Data
public class UpdateProductRequest implements Request<Void> {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String provider;
    private Review review;
    private Long categoryId;

}
