package com.sample.server.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.sample.server.dto.BookDTO;

@Component
public class BooksRepository {
	
	ArrayList<BookDTO> bookList;
	
	public BooksRepository() {
		bookList = new ArrayList<>();
		BookDTO bookDTO = new BookDTO(1, "A - book ", "A author");
		bookList.add(bookDTO);
		BookDTO bookDTO2 =new BookDTO(2, "B- book ", "B author");
		bookList.add(bookDTO2);
		BookDTO bookDTO3 =new BookDTO(3, "C- book ", "C author");
		bookList.add(bookDTO3);
	}
	
	public List<BookDTO> searchBookById(int id) {
		long count = bookList.stream().filter(p -> p.getId() == id).count();
		System.out.println("no of books found >> " + count);

		return bookList.stream().filter(p -> p.getId() == id).collect(Collectors.toList());
	}
	
	public List<BookDTO> display(){
		System.out.println("list length >> "+bookList);
		return bookList;
	}
	
	
	
}
