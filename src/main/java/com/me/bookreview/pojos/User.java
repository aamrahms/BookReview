package com.me.bookreview.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
import org.springframework.lang.NonNull;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table
public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int userid;
	@NaturalId
	@NonNull
	private String username;
	@NonNull
	private String name;
	@NonNull
	private String email;
	@NonNull
	private String password;
	private String dateOfRegistration;
	private String profilePicture;
	@OneToMany(mappedBy="reader")
	private Set<Book> readingList;
	@OneToMany(mappedBy="author")
	private Set<Book> publishedBooks;

	private String role; //User type : null/author
	private String profileLink; //	Website 

	public User() {
		this.dateOfRegistration = String.valueOf(new Date());
		this.readingList= new HashSet<Book>();
		this.publishedBooks= new HashSet<Book>();
		this.role=null;
}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDateOfRegistration() {
		return dateOfRegistration;
	}
	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	public String getRole() {
		return role;
	}

	public Set<Book> getReadingList() {
		return readingList;
	}
	public void setReadingList(Set<Book> readingList) {
		this.readingList = readingList;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	public String getProfileLink() {
		return profileLink;
	}
	public void setProfileLink(String profileLink) {
		this.profileLink = profileLink;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
	public Set<Book> getPublishedBooks() {
		return publishedBooks;
	}
	public void setPublishedBooks(Set<Book> publishedBooks) {
		this.publishedBooks = publishedBooks;
	}
	public void addBookToReadinglist(Book book) {
		readingList.add(book);

	}
	public void removeBookFromReadinglist(Book book) {
		readingList.remove(book);

	}
	public void addBookToPublishedlist(Book book) {
		publishedBooks.add(book);

	}
	public void removeBookFromPublishedlist(Book book) {
		publishedBooks.remove(book);

	}
	
}
