package spring_boot_security.product.application.command.delete;

import lombok.AllArgsConstructor;
import lombok.Data;
import spring_boot_security.common.application.mediator.Request;

@Data
@AllArgsConstructor
public class DeleteProductRequest implements Request<Void> {

    private Long id;

}
