package com.me.bookreview.pojos;

import java.util.List;

import javax.persistence.OneToMany;

public class Author extends User{
	private int rating;
	@OneToMany
	private List<Book> publishedBooks;
	
}
