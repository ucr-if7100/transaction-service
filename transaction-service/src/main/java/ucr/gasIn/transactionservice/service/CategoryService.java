package ucr.gasIn.transactionservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucr.gasIn.transactionservice.domain.Category;
import ucr.gasIn.transactionservice.repository.CategoryRepository;

import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired

    private CategoryRepository repository;

    public List<Category> listAll() {
        return repository.findAll();
    }

    public void save(Category category) {
        repository.save(category);
    }

    public Category get(int id_Category) {
        return repository.findById(id_Category).get();
    }

    public void update(Category entity) {
        Category entityToUpdate = repository.findById(entity.getId()).get();
        if(entityToUpdate != null) {
            repository.save(entity);
        }
    }
    public void delete(int id) {repository.deleteById(id);
    }
}
