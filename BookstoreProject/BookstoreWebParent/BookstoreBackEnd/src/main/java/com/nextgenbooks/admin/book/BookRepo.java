package com.nextgenbooks.admin.book;

import org.springframework.data.repository.CrudRepository;

import com.nextgenbooks.common.entity.Book;

public interface BookRepo extends CrudRepository<Book, Integer> {

}
