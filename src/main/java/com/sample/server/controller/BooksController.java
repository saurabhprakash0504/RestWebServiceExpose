package com.sample.server.controller;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.sample.exception.BookNotFound;
import com.sample.exception.UnauthorizedException;
import com.sample.server.dto.BookDTO;
import com.sample.server.repository.BooksRepository;

@RestController
public class BooksController {
	
	@Autowired
	private BooksRepository booksRepository;

	@GetMapping("/searchBook/{id}")
	public ResponseEntity findBook(@PathVariable("id") Integer id) {

		//if (authString.equals("test")) {
			List<BookDTO> result = booksRepository.searchBookById(id);
			if (result.isEmpty()) {
				throw new BookNotFound();
			} else {
				return ResponseEntity.ok(booksRepository.searchBookById(id));
			}
		//}

	/*
	 * else { throw new UnauthorizedException(); }
	 */
	}
	
	@GetMapping("/display")
	List<BookDTO> displayAllBooks(){
		return booksRepository.display();
	}
	
}
