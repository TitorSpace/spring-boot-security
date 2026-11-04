package spring_boot_security.category.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryCategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
