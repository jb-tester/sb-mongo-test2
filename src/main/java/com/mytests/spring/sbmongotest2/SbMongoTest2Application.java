package com.mytests.spring.sbmongotest2;

import com.mytests.spring.sbmongotest2.services.AuthorService;
import com.mytests.spring.sbmongotest2.services.BookService;
import com.mytests.spring.sbmongotest2.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbMongoTest2Application implements CommandLineRunner {

    @Autowired
    private com.mytests.spring.sbmongotest2.model.DBSetUp DBSetUp;
    @Autowired
    private BookService bookService;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private AuthorService authorService;


    public static void main(String[] args) {
        SpringApplication.run(SbMongoTest2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
     DBSetUp.setup();
     bookService.displayBooks();
     authorService.displayAuthors();
     publisherService.displayPublishers();
    }
}
