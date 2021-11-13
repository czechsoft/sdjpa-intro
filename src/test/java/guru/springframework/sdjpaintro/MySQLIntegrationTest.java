package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.repositories.AuthorRepository;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by jt on 7/4/21.
 */
@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"guru.springframework.sdjpaintro.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MySQLIntegrationTest {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    @Test
    void testMySQLBook() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

    }

    @Test
    void testMySQLAuthor() {
        long countBefore = authorRepository.count();
        assertThat(countBefore).isEqualTo(2);

    }

}


