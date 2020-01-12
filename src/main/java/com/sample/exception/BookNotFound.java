package com.sample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "BookNotFound")
public class BookNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BookNotFound() {
		super();
	}

}
