package com.dico.blogs;

import com.dico.blogs.category.model.Category;
import com.dico.blogs.category.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CategoryTest {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void CreateCategory(){
        //instantiating the new category.
        Category category = new Category();

        //adding data to the role fields
        category.setCategoryName("Software Engineering");
        category.setCategoryDetail("A Haulistic software development process");

        //saving the data in the database
        Category savedCategory = categoryRepository.save(category);

        //checking that category entity was actually created in the database
        Category existingCategory = entityManager.find(Category.class, savedCategory.getId());

       /*
       Asserting that the category found on the database was the originally saved category.
       if the assertion is true then the test passed for category creation.
        */
        assertThat(existingCategory.getCategoryName()).isEqualTo(category.getCategoryName());
    }

}
