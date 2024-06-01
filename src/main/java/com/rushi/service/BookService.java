package com.rushi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rushi.model.Book;
import com.rushi.repository.BookRepository;

@Service
public class BookService {

	 @Autowired
	    private BookRepository bookRepository;

	    public List<Book> getAllBooks() {
	        return bookRepository.findAll();
	    }

	    public Book getBookById(Long id) {
	        return bookRepository.findById(id).orElse(null);
	    }

	    public Book saveBook(Book book) {
	        return bookRepository.save(book);
	    }

	    public void deleteBook(Long id) {
	        bookRepository.deleteById(id);
	    }

	    public Book updateBook(Long id, Book updatedBook) {
	        if (bookRepository.existsById(id)) {
	            updatedBook.setId(id);
	            return bookRepository.save(updatedBook);
	        }
	        return null;
	    }
	
}
