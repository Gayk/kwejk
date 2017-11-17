package pl.mgaik.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.mgaik.form.CategoryForm;
import pl.mgaik.models.Category;
import pl.mgaik.repositories.CategoryCrudrepository;
import pl.mgaik.repositories.GifRepository;

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

