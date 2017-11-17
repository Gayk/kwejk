package pl.mgaik.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mgaik.models.Category;
import pl.mgaik.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> showAll() {
        return categoryRepository.showAll();
    }
}
