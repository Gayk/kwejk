package pl.akalkowski.demo.repositories;

import org.springframework.stereotype.Repository;
import pl.akalkowski.demo.models.Category;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {

    ConfigurationRepository configurationRepository;

    public List<Category> categories = new ArrayList<>();


    public List<Category> showAll() {

        return categories;
    }

    public void add(Category category) {

        categories.add( category );
    }

    public Category findById(Integer id) {
        for (Category category : categories) {
            if (category.getId().equals( id )) {
                return category;
            }
        }
        return null;
    }

    public Category getCategory(int id) {
        for (Category category : categories) {
            if (category.getId().equals( id )) {
                return category;
            }
        }
        return new Category();
    }

    public Integer getLastId() {
        return categories.get( categories.size() + 1 ).getId();
    }


}
