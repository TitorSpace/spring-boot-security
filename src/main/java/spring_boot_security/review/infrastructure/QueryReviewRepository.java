package spring_boot_security.review.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryReviewRepository extends JpaRepository<ReviewEntity, Long> {
}
