package com.mytests.spring.sbmongotest2.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;
import java.util.List;

@Document
public class Publisher {

  @Id
  ObjectId id;

  String name;

  @ReadOnlyProperty
  @DocumentReference(lookup="{'publisherId':?#{#self._id} }")
  List<Book> books;

  public ObjectId getId() {
    return id;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }



  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Book> getBooks() {
    return books;
  }

  public Publisher(String name) {

    this.name = name;
  }

  @Override
  public String toString() {
    return "Publisher{" +
            "name='" + name + '\'' +
            ", books=" + books +
            '}';
  }
}