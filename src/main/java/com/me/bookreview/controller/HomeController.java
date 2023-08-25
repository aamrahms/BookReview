package com.me.bookreview.controller;


import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.bookreview.dao.BookDAO;
import com.me.bookreview.dao.CommentDAO;
import com.me.bookreview.dao.PostDAO;
import com.me.bookreview.dao.UserDAO;
import com.me.bookreview.pojos.Book;
import com.me.bookreview.pojos.Comment;
import com.me.bookreview.pojos.Post;
import com.me.bookreview.pojos.User;
import com.mysql.cj.Session;

/**
 * Handles requests for the application home page.
 */
@Controller
@Transactional
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.htm", method = RequestMethod.GET)
	public String home(HttpServletRequest request, BookDAO bookdao) {
		List<Book> books=bookdao.list();
		request.setAttribute("books", books );
		return "home";
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String landingPage(HttpServletRequest request, BookDAO bookdao) {
		List<Book> books=bookdao.list();
		request.setAttribute("books", books );
		return "home";
	}
	@RequestMapping(value="/registerPage.htm", method=RequestMethod.GET)
	public String returnRegistrationPage() {
		return "reg";
	}
	@RequestMapping(value="/loginPage.htm", method=RequestMethod.GET)
	public String returnLoginPage() {
		return "login";
	}
	@RequestMapping(value="/header.htm", method=RequestMethod.GET)
	public String returnHeader() {
		return "header";
	}
	@RequestMapping(value="/footer.htm", method=RequestMethod.GET)
	public String returnFooter() {
		return "footer";
	}
	@RequestMapping(value="/userProfile{userid}.htm", method=RequestMethod.GET)
	public String returnUserProfile(@PathVariable int userid, HttpServletRequest request, PostDAO postdao, CommentDAO commentdao,UserDAO userdao) {
		List<Post> posts=postdao.list(userid);
		request.setAttribute("myposts", posts);
		List<Comment> comments=commentdao.list(userid);
		request.setAttribute("mycomments", comments);
		User user=(User) userdao.get(userid);
		request.setAttribute("thisuser", user);
		Set<Book> myshelf=user.getReadingList();
		request.setAttribute("myshelf", myshelf);
		Set<Book> mybooks=user.getPublishedBooks();
		request.setAttribute("mybooks", mybooks);
		return "profile";
	}
	@RequestMapping(value="/addBookPage.htm", method=RequestMethod.GET)
	public String addBookPage(HttpServletRequest request,UserDAO userdao) {
		List<User> authors=userdao.listAuthors();
		request.setAttribute("authors", authors);
		request.setAttribute("addupdate", 1);
		return "book";
	}
	@RequestMapping(value="/editBookPage{id}.htm", method=RequestMethod.GET)
	public ModelAndView editBookPage(HttpServletRequest request,@PathVariable int id, UserDAO userdao, BookDAO bookdao) {
		List<User> authors=userdao.listAuthors();
		Book book= (Book) bookdao.getById(id);
		request.setAttribute("authors", authors);
		request.setAttribute("addupdate", 2);
		return new ModelAndView("book", "book", book);
	}
	
	@RequestMapping(value="/bookPage{bookid}", method=RequestMethod.GET)
	public String loadBookPage(@PathVariable int bookid, HttpServletRequest request,BookDAO bookdao) {
		Book book = bookdao.getById(bookid);
		System.out.println("xyzzzzzz");
		request.setAttribute("thisbook", book);
		return "bookPage";
	}
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String loadTestPage() {
		return "test";
	}
	
}
