package ucr.gasIn.transactionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucr.gasIn.transactionservice.domain.Category;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Integer> {
}
