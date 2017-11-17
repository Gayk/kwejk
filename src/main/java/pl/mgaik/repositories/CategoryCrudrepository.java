package pl.mgaik.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mgaik.models.Category;

import java.util.List;

/**
 * Created by monik on 17.11.2017.
 */
@Repository
public interface CategoryCrudrepository extends CrudRepository<Category, Integer> {
    public List<Category> findAll();


}
