package swd20.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd20.Bookstore.domain.Book;
import swd20.Bookstore.domain.BookRepository;
import swd20.Bookstore.domain.Category;
import swd20.Bookstore.domain.CategoryRepository;
import swd20.Bookstore.domain.User;
import swd20.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("Save a couple of books");
			crepository.save(new Category("Scifi"));
			crepository.save(new Category("Comic"));
			crepository.save(new Category("Thriller"));
			crepository.save(new Category("Fantacy"));
			

			brepository.save(new Book("Harry Potter", "J.K. Rowling", "986412", 10.0, crepository.findByName("Fantacy").get(0)));
			brepository.save(new Book("Peilimiäs", "Lars Kepler", "245252", 11.0, crepository.findByName("Thriller").get(0)));
			
			User user1 = new User("user", "$2a$10$jiV4ezIR0cAHmE./sERX3.Ze1fOrgICbRPplqjlcgS7w0TlHo1OBu", "USER");
			User user2 = new User("admin", "$2a$10$lCYyGV4QEXaLlsWpWjfgvuStUHMyFo5jGkezo8ST./x3K1dQXVqN2", "ADMIN");
			
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
