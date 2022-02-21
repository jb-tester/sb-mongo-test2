package com.mytests.spring.sbmongotest2.services;

import com.mytests.spring.sbmongotest2.model.Author;
import com.mytests.spring.sbmongotest2.model.Book;
import com.mytests.spring.sbmongotest2.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * *
 * <p>Created by irina on 2/21/2022.</p>
 * <p>Project: sb-mongo-test2</p>
 * *
 */
@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void displayAuthors(){
        System.out.println("======= authors tests ==========");
        for (Author author : authorRepository.findAll()) {
            System.out.println(author.toString());
        }
    }
}
