package org.hillel.hackatongreenteam.controller;

import org.hillel.hackatongreenteam.model.Category;
import org.hillel.hackatongreenteam.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping(value = "/admin/category")
    public RestResponse create(@RequestBody Category category) {
        RestResponse response = new RestResponse();
        response.setStatus(201);
        response.setMessage("A new category has created");
        response.setData(categoryRepository.save(category));

        return response;
    }

    @GetMapping(value = "/category")
    public RestResponse list() {
        RestResponse response = new RestResponse();
        response.setStatus(200);
        response.setData(categoryRepository.findAll());

        return response;
    }

}
