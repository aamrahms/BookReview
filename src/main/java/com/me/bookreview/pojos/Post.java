package com.me.bookreview.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private int postid;
	
	@ManyToOne(fetch = FetchType.LAZY )
	private Book book;
	@ManyToOne
	private User user; 
	@Column(columnDefinition="TEXT")
	private String review;
	private int rating;
	
	private String dateOfPost;
	
	@OneToMany(mappedBy="post",cascade = CascadeType.ALL, orphanRemoval=true, fetch = FetchType.EAGER)
	private Set<Comment> comments;

	@Transient
	private MultipartFile imageFile;
	private String image;
	
	
	public Post() {
		this.dateOfPost = String.valueOf(new Date());
		this.comments= new HashSet<Comment>();
	}
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	public MultipartFile getImageFile() {
		return imageFile;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public String getDateOfPost() {
		return dateOfPost;
	}
	public void setDateOfPost(String dateOfPost) {
		this.dateOfPost = dateOfPost;
	}
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void addComment(Comment comment) {
		comments.add(comment);
//		comments.setPost(this);
	}
	public void removeComment(Comment comment) {
		comments.remove(comment);
//		comments.setPost(null);
	}

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
}
