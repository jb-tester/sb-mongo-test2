package com.mytests.spring.sbmongotest2.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * *
 * <p>Created by irina on 2/21/2022.</p>
 * <p>Project: sb-mongo-test2</p>
 * *
 */
@Document
public class Book {
    @Id
    ObjectId id;
    @Field
    String title;

    @Field
    ObjectId publisherId;

    @Field @DocumentReference(lookup = "{firstName:?#{fn},lastName:?#{ln}}")
    Author author;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ObjectId getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(ObjectId publisherId) {
        this.publisherId = publisherId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book(String title, Author author, ObjectId publisherId) {
        this.title = title;
        this.author = author;
        this.publisherId = publisherId;

    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", publisherId=" + publisherId +
                ", author=" + author +
                '}';
    }
}
