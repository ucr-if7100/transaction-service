package ucr.gasIn.transactionservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.gasIn.transactionservice.domain.Category;
import ucr.gasIn.transactionservice.service.CategoryService;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/api/Category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/get")
    public List<Category> list() {
        return service.listAll();
    }

    @GetMapping("/getCategory/{id}")
    public ResponseEntity<Category> get(@PathVariable Integer id) {
        try {
            Category category = service.get(id);
            return new ResponseEntity<Category>(category, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/insert")
    public void add(@RequestBody Category category) {service.save(category);
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") int id,
                       @RequestBody Category category) {
        Category entity = category;
        entity.setId(id);
        service.update(entity);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
