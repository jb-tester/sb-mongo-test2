package com.mytests.spring.sbmongotest2.repositories;

import com.mytests.spring.sbmongotest2.model.Author;
import com.mytests.spring.sbmongotest2.model.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * *
 * <p>Created by irina on 2/21/2022.</p>
 * <p>Project: sb-mongo-test2</p>
 * *
 */
public interface AuthorRepository extends MongoRepository<Author, ObjectId> {

    List<Author> findAll();

    @Query("{firstName: ?0,lastName: ?1}")
    List<Author> selectByName(String fname, String lname);
}
