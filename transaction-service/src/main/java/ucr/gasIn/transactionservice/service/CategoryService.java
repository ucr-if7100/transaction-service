package ucr.gasIn.transactionservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucr.gasIn.transactionservice.domain.Category;
import ucr.gasIn.transactionservice.dto.CategoryDTO;
import ucr.gasIn.transactionservice.dto.TransactionDTO;
import ucr.gasIn.transactionservice.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryService {
    @Autowired

    private CategoryRepository repository;

    public List<CategoryDTO> listAll() {
        return repository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public void save(CategoryDTO categoryDTO) {
        Category category = convertDtoToEntity(categoryDTO);
        repository.save(category);
    }

    public CategoryDTO get(int id_Category) {
        return repository.findById(id_Category).map(this::convertEntityToDto).orElse(null);
    }

    public void update(CategoryDTO categoryDTO) {
        Category category = convertDtoToEntity(categoryDTO);
        Category entityToUpdate = repository.findById(category.getId()).orElse(null);
        if(entityToUpdate != null) {
            repository.save(category);
        }else {
            System.out.println("No se encontro el usuario");
        }
    }
    public void delete(int id) {repository.deleteById(id);
    }



    private CategoryDTO convertEntityToDto(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());
        categoryDTO.setId_user(category.getId_user());
        return categoryDTO;
    }

    private Category convertDtoToEntity(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        category.setId_user(categoryDTO.getId_user());
        return category;
    }


}
