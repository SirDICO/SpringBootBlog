package com.dico.blogs;

import com.dico.blogs.category.model.Category;
import com.dico.blogs.post.model.Post;
import com.dico.blogs.post.repository.PostRepository;
import com.dico.blogs.post.service.PostService;
import com.dico.blogs.user.model.Role;
import com.dico.blogs.user.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.DATE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class PostTest {

    @Autowired
    private PostRepository postRepository ;
    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void CreatePost(){
        //instantiating the new post.
        Post post = new Post();


        //adding data to the post fields
        post.setTitle("Introduction to software engineering");
        post.setDescription("<p>n the book of Ecclesiastes, we read about the revelation of God’s purposes to\n" +
                "the hearts of humankind. The third chapter begins, “To everything there is a\n" +
                "season, a time for every purpose under heaven” (Ecclesiastes 3:1 nkjv). God has\n" +
                "not only given you a purpose, but, according to this Scripture, He has also\n" +
                "determined the time for that purpose to be accomplished. There is “a time for\n" +
                "every purpose.” Whatever you were born to do, God has assigned a season in\n" +
                "which it is to be done—and that season is the duration of your life. Do you see\n" +
                "why it is crucial for you to know the vision that is in your heart? Your purpose\n" +
                "can be fulfilled only during the time you are given on earth to accomplish it.\n" +
                "Within this season called life, God has also appointed specific times for\n" +
                "portions of your purpose to be accomplished. As you pursue the dream God has\n" +
                "given you, He will bring it to fruition during the period of your life when it is\n" +
                "meant to be completed. As Ecclesiastes 3:11 says, “He has made everything\n" +
                "beautiful in its time.”\n" +
                "Some people wish they had been born during a different time in history. Yet if\n" +
                "you had been born a thousand years ago, or even a hundred years ago, you\n" +
                "would have been miserable because you would have been living in the wrong\n" +
                "time to complete your purpose and vision. God chose when and where you were\n" +
                "born for a reason. You didn’t just show up on earth. Ecclesiastes 3:2 says that\n" +
                "there is “a time to be born.” You were born at the right time to accomplish your\n" +
                "vision during your generation.\n </p>");
//        Category category = new Category();
//        post.setUser( new User().getId());

        //saving the data in the database
        Post savedPost = postRepository.save(post);

        //checking that Post entity was actually created in the database
        Post existingPost = entityManager.find(Post.class, savedPost.getId());

       /*
       Asserting that the post found on the database was the originally saved post.
       if the assertion is true then the test passed for post creation.
        */

        assertThat(existingPost.getDescription()).isEqualTo(post.getDescription());

    }

}
