package ucr.gasIn.transactionservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.gasIn.transactionservice.domain.Category;
import ucr.gasIn.transactionservice.dto.CategoryDTO;
import ucr.gasIn.transactionservice.service.CategoryService;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/Category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/get")
    public List<CategoryDTO> list() {
        return service.listAll();
    }

    @GetMapping("/getCategory/{id}")
    public ResponseEntity<CategoryDTO> get(@PathVariable Integer id) {
        try {
            CategoryDTO category = service.get(id);
            return new ResponseEntity<CategoryDTO>(category, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<CategoryDTO>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/insert")
    public void add(@RequestBody CategoryDTO categoryDTO) {service.save(categoryDTO);
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") int id,
                       @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO entity = categoryDTO;
        entity.setId(id);
        service.update(entity);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
