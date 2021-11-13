package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Author;
import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.AuthorRepository;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/12/21.
 */
@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse");
        Book savedDDD = bookRepository.save(bookDDD);

        Book bookSIA = new Book("Spring In Action", "234234", "Oriely");
        Book savedSIA = bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id: " + book.getId());
            System.out.println("Book Title: " + book.getTitle());
        });

        Author author = new Author("Jan", "Kowalski", "about Jan");
        authorRepository.save(author);
        author = new Author("Henryk", "Sienkiewicz", "about Henryk");
        authorRepository.save(author);
        authorRepository.findAll().forEach(author1 -> {
            System.out.println("Author id: "+author1.getId());
            System.out.println("Author surname: "+author1.getSurname());
        });

    }
}
