package com.me.bookreview.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.me.bookreview.dao.BookDAO;
import com.me.bookreview.dao.CommentDAO;
import com.me.bookreview.dao.PostDAO;
import com.me.bookreview.pojos.Book;
import com.me.bookreview.pojos.Comment;
import com.me.bookreview.pojos.Post;
import com.me.bookreview.pojos.User;

@Controller
public class PostController {

	@RequestMapping(value="/post{bookid}.htm", method=RequestMethod.POST)
	public ModelAndView postForBook(@PathVariable int bookid, @ModelAttribute Post post, HttpServletRequest request,BookDAO bookdao, PostDAO postdao) {
		User user= (User) request.getSession().getAttribute("user");
		Book book = bookdao.getById(bookid);
		float rating=book.getRating();
		rating+=post.getRating();
		int size=book.getBookReviews().size();
		if(size!=0) {
			rating/=size;
			book.setRating(rating);
		}
		post.setUser(user);
		post.setBook(book);
		postdao.save(post);
		book.addPost(post);
		bookdao.update(book);
		request.setAttribute("thisbook", book);
		return new ModelAndView("redirect:bookPage"+String.valueOf(bookid));
	}
	@RequestMapping(value="/addComment{postid}", method=RequestMethod.POST)
	public ModelAndView commentForPost(@PathVariable int postid, @ModelAttribute Comment comment, HttpServletRequest request,BookDAO bookdao, PostDAO postdao, CommentDAO commentdao) {
		User user= (User) request.getSession().getAttribute("user");
		Post post = postdao.getById(postid);
		comment.setUser(user);
		comment.setPost(post);
		commentdao.save(comment);
		post.addComment(comment);
		postdao.update(post);
		String page="bookPage"+String.valueOf(post.getBook().getBookid());
		return new ModelAndView("redirect:"+page);
	}
}
