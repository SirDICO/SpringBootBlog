package com.dico.blogs;

import com.dico.blogs.user.model.Role;
import com.dico.blogs.user.model.User;
import com.dico.blogs.user.repository.RoleRepository;
import com.dico.blogs.user.repository.UserRepository;
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
public class RoleRepositoryTest {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void CreateRole(){
        //instantiating the new role.
        Role role = new Role();


        //adding data to the role fields
        role.setDescription("Administrator");
        role.setDetails("Overall Admin with highest authority ");

        //saving the data in the database
        Role savedRole = roleRepository.save(role);

        //checking that role entity was actually created in the database
        Role existingRole = entityManager.find(Role.class, savedRole.getId());

       /*
       Asserting that the role found on the database was the originally saved role.
       if the assertion is true then the test passed for user creation.
        */
        assertThat(existingRole.getDescription()).isEqualTo(role.getDescription());
    }
}
