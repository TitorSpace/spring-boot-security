package spring_boot_web_jpa.category.infrastructure;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import spring_boot_web_jpa.category.domain.Category;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CategoryEntityMapper {

    @Mapping(target = "products", ignore = true)
    Category maptoCategory(CategoryEntity categoryEntity);

}
