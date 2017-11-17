package pl.akalkowski.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.akalkowski.demo.form.CategoryForm;
import pl.akalkowski.demo.models.Category;
import pl.akalkowski.demo.repositories.CategoryCrudrepository;
import pl.akalkowski.demo.repositories.CategoryRepository;
import pl.akalkowski.demo.repositories.GifRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryCrudrepository categoryCrudrepository;
    @Autowired
    GifRepository gifRepository;

    @GetMapping("")
    public String showAllCategories(ModelMap modelMap) {
        modelMap.addAttribute( "categories", categoryCrudrepository.findAll() );
        return "categories";
    }

    @GetMapping("addcategory")
    public String addCategory(Model model) {
        model.addAttribute( "name", new CategoryForm() );
        return "add-category";
    }

    @PostMapping("/addcategory")
    public String addCategory(@RequestParam("name") String name, Model model) {
        categoryCrudrepository.save( new Category( name ) );
        System.out.println();
        System.out.println( "Dodano nową kategorie" );
        return "add-category";
    }
}

