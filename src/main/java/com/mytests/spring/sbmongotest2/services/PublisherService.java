package com.mytests.spring.sbmongotest2.services;

import com.mytests.spring.sbmongotest2.model.Author;
import com.mytests.spring.sbmongotest2.model.Publisher;
import com.mytests.spring.sbmongotest2.repositories.AuthorRepository;
import com.mytests.spring.sbmongotest2.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * *
 * <p>Created by irina on 2/21/2022.</p>
 * <p>Project: sb-mongo-test2</p>
 * *
 */
@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public void displayPublishers(){
        System.out.println("======= publishers tests ==========");
        for (Publisher publisher : publisherRepository.findAll()) {
            System.out.println(publisher.toString());
        }
    }
}
