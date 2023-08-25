package com.me.bookreview.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue
	private int commentid;
	@ManyToOne(fetch = FetchType.LAZY )
	private Post post;
	@ManyToOne
	private User user;
	@Column(columnDefinition="TEXT")
	private String message;
	private String dateOfComment;
	public Comment() {
		this.dateOfComment = String.valueOf(new Date());
	}
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDateOfComment() {
		return dateOfComment;
	}
	public void setDateOfComment(String dateOfComment) {
		this.dateOfComment = dateOfComment;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
}
