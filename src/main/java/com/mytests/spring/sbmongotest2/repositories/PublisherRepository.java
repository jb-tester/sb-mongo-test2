package com.mytests.spring.sbmongotest2.repositories;

import com.mytests.spring.sbmongotest2.model.Publisher;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * *
 * <p>Created by irina on 2/21/2022.</p>
 * <p>Project: sb-mongo-test2</p>
 * *
 */
public interface PublisherRepository extends MongoRepository<Publisher, ObjectId> {

    List<Publisher> findAll();

    Publisher findFirstIdByName(String name);
}
