package pl.akalkowski.demo.models;

import org.hibernate.annotations.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import pl.akalkowski.demo.form.CategoryForm;
import pl.akalkowski.demo.repositories.CategoryRepository;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(CategoryForm form) {
        name = form.getName();
    }

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
