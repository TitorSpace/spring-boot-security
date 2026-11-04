package spring_boot_security.common.domain;

//THis class is in charge of give us the pagination query

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaginationQuery {

    private int page;
    private int Size;
    private String sortBy;
    private String direction;
}
