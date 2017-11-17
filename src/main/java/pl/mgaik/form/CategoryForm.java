package pl.mgaik.form;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by monik on 16.11.2017.
 */
public class CategoryForm {
    @NotBlank
    @Pattern(regexp = "[a-z]*[A-Z]*")
    private String name;

    public CategoryForm() {
    }

    public CategoryForm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryForm{" +
                "name='" + name + '\'' +
                '}';
    }
}
