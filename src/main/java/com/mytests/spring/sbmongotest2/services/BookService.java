package com.mytests.spring.sbmongotest2.services;

import com.mytests.spring.sbmongotest2.model.Author;
import com.mytests.spring.sbmongotest2.model.Book;
import com.mytests.spring.sbmongotest2.repositories.BookRepository;
import com.mytests.spring.sbmongotest2.repositories.PublisherRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * *
 * <p>Created by irina on 2/21/2022.</p>
 * <p>Project: sb-mongo-test2</p>
 * *
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;


    public void displayBooks(){
        System.out.println("======= books tests ==========");
        for (Book book : bookRepository.findAll()) {
            System.out.println(book.toString());
        }
        System.out.println("--- books by author: ----");
        for (Book book : bookRepository.findBooksByAuthor(new Author("Ivan","Turgenev"))) {
            System.out.println(book.toString());
        }
        System.out.println("--- books by publisher: ----");
        ObjectId pid = publisherRepository.findFirstIdByName("AAA").getId();
        for (Book book : bookRepository.findByPublisherId(pid) ) {
            System.out.println(book.toString());
        }
    }
}
