package com.me.bookreview.pojos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.transaction.Transactional;

import com.me.bookreview.pojos.Post;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.stereotype.Component;
@Component
@Entity
@Transactional
public class Book {
	
	@Id
	@GeneratedValue
	private int bookid;

	private String name;

	@ManyToOne
	private User author;
	@Column(columnDefinition="TEXT")
	private String description;
	private float rating; 
	private String publishingDate; 
	private int numberOfPages;
	@ElementCollection(targetClass=String.class)
	private Set<String> genre = new HashSet<String>();
	private String language;
	private String status;
	
	@ManyToOne(fetch = FetchType.LAZY )
	private User reader;
//	
//	@ManyToMany(mappedBy = "userid")
//    private Set<User> users = new HashSet<User>();
	
//	private int readCount;
//	private int wantToReadCount;
//	private int readingCount;
	
	@OneToMany(mappedBy="book",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<Post> bookReviews;
	

	
	@Transient
	private MultipartFile imageFile;
//	@Column(name="picture")
	private String image;
	
	
	public Book() {
		this.bookReviews= new HashSet<Post>();
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	
	public MultipartFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public String getAuthor() {
//		return author;
//	}
//	public void setAuthor(String author) {
//		this.author = author;
//	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getPublishingDate() {
		return publishingDate;
	}
	public void setPublishingDate(String publishingDate) {
		this.publishingDate = publishingDate;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	public Set<String> getGenre() {
		return genre;
	}
	public void setGenre(Set<String> genre) {
		this.genre = genre;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

//	public int getReadCount() {
//		return readCount;
//	}
//	public void setReadCount(int readCount) {
//		this.readCount = readCount;
//	}
//	public int getWantToReadCount() {
//		return wantToReadCount;
//	}
//	public void setWantToReadCount(int wantToReadCount) {
//		this.wantToReadCount = wantToReadCount;
//	}
//	public int getReadingCount() {
//		return readingCount;
//	}
//	public void setReadingCount(int readingCount) {
//		this.readingCount = readingCount;
//	}

	public Set<Post> getBookReviews() {
		return bookReviews;
	}
	public void setBookReviews(Set<Post> bookReviews) {
		this.bookReviews = bookReviews;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void addPost(Post post) {
		bookReviews.add(post);
	}
	public void removeComment(Post post) {
		bookReviews.remove(post);
	}
	public User getReader() {
		return reader;
	}
	public void setReader(User reader) {
		this.reader = reader;
	}

	
}
