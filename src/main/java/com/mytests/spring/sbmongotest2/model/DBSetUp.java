package com.mytests.spring.sbmongotest2.model;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * *
 * <p>Created by irina on 2/21/2022.</p>
 * <p>Project: sb-mongo-test2</p>
 * *
 */
@Service
public class DBSetUp {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void setup(){
        mongoTemplate.dropCollection("author");
        mongoTemplate.dropCollection("publisher");
        mongoTemplate.dropCollection("book");
        Publisher publisher1 = new Publisher("AAA");
        Publisher publisher2 = new Publisher("BBB");
        Publisher publisher3 = new Publisher("CCC");
        Author author1 = new Author("Ivan","Turgenev");
        Author author2 = new Author("Lev","Tolstoy");
        Author author3 = new Author("Anton","Chekhov");
        Author author4 = new Author("Fedor","Dostoevsky");
        mongoTemplate.insert(publisher1);
        mongoTemplate.insert(publisher2);
        mongoTemplate.insert(publisher3);
        mongoTemplate.insert(author1);
        mongoTemplate.insert(author2);
        mongoTemplate.insert(author3);
        mongoTemplate.insert(author4);
        ObjectId publisherId1 = mongoTemplate.findOne(new Query(
                Criteria.where("name").is("AAA")), Publisher.class).getId();
        Book book1 = new Book("Fathers And Sons", author1,
                publisherId1
                );
        Book book2 = new Book("Anna Karenina", author2,
                publisherId1
        );
        Book book3 = new Book("Cherry Garden", author3,
                publisherId1
        );
        Book book4 = new Book("Idiot", author4,
                mongoTemplate.findOne(new Query(
                        Criteria.where("name").is("BBB")), Publisher.class).getId()
        );
        Book book5 = new Book("White Nights", author4,
                mongoTemplate.findOne(new Query(
                        Criteria.where("name").is("BBB")), Publisher.class).getId()
        );
        Book book6 = new Book("Three Sisters", author3,
                mongoTemplate.findOne(new Query(
                        Criteria.where("name").is("CCC")), Publisher.class).getId()
        );
        Book book7 = new Book("Spring Waters", author1,
                mongoTemplate.findOne(new Query(
                        Criteria.where("name").is("CCC")), Publisher.class).getId()
        );
        Book book8 = new Book("War And Piece", author2,
                mongoTemplate.findOne(new Query(
                        Criteria.where("name").is("CCC")), Publisher.class).getId()
        );
        mongoTemplate.insert(book1);
        mongoTemplate.insert(book2);
        mongoTemplate.insert(book3);
        mongoTemplate.insert(book4);
        mongoTemplate.insert(book5);
        mongoTemplate.insert(book6);
        mongoTemplate.insert(book7);
        mongoTemplate.insert(book8);
    }
}
