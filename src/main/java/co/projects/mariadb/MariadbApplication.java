package co.projects.mariadb;

import co.projects.mariadb.entity.Author;
import co.projects.mariadb.entity.Book;
import co.projects.mariadb.repository.BookRepo;
import co.projects.mariadb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class MariadbApplication implements CommandLineRunner {

    @Autowired
    BookService bookService ;
    @Autowired
    BookRepo bookRepo;
    public static void main(String[] args) {
        SpringApplication.run(MariadbApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
      /*  Book book =  new Book(1,"Java 101,","1234567890",new Author(1,"David Yates","New York"));

        bookService.saveBook(book);
        book =  new Book(2,"Python 101,","098765432",new Author(2,"Mathew Yates","London"));
        bookService.saveBook(book);*/

      bookRepo.save(new Book(1,"Java 101,","1234567890",new Author(1,"David Yates","New York")));
      bookRepo.save(new Book(2,"Python 101,","098765432",new Author(2,"Mathew Yates","London")));
    }
@Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/*"))
                .apis(RequestHandlerSelectors.basePackage("co.projects"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails(){
        return  new ApiInfo(
                "Library API",
                "Sample Api fot JPA demo",
                "1",
                "Free to change",
                new springfox.documentation.service.Contact("Neenu Shaji","www.neenu.com","neenu@Abc.com"),
                "API Licence",
                "www.xyz.com",
                Collections.emptyList());
    }
}
