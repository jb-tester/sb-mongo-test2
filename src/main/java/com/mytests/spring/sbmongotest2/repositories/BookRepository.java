package com.mytests.spring.sbmongotest2.repositories;

import com.mytests.spring.sbmongotest2.model.Author;
import com.mytests.spring.sbmongotest2.model.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * *
 * <p>Created by irina on 2/21/2022.</p>
 * <p>Project: sb-mongo-test2</p>
 * *
 */
public interface BookRepository extends MongoRepository<Book, ObjectId> {

    List<Book> findAll();
    List<Book> findBooksByAuthor(Author author);

    List<Book> findByPublisherId(ObjectId publisherId);
}
