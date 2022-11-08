package com.dico.blogs;

import com.dico.blogs.user.model.User;
import com.dico.blogs.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class userRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;


    //Test for creating a new user in the database
    @Test
    public void testCreateUser(){
        //instantiating the new user.
        User user = new User();


        //adding data to the user fields
        user.setUsername("Ikechukwu");
        user.setPassword("Masterike");
        user.setFirstname("Ikenna");
        user.setLastname("Chukwu");

        //saving the data in the database
       User savedUser = userRepository.save(user);

       //checking that user entity was actually created in the database
       User existingUser = entityManager.find(User.class, savedUser.getId());

       /*
       Asserting that the user found on the database was the originally saved user.
       if the assertion is true then the test passed for user creation.
        */

       assertThat(existingUser.getUsername()).isEqualTo(user.getUsername());
    }
//
    @Test
    public void testFindUserByUsername(){
        String username = "Amen";
        User user = userRepository.findByUsername(username);
        assertThat(user).isNotNull();
    }
}
