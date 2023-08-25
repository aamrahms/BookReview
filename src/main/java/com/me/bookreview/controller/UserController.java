package com.me.bookreview.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.me.bookreview.dao.BookDAO;
import com.me.bookreview.dao.UserDAO;
import com.me.bookreview.pojos.Book;
import com.me.bookreview.pojos.Post;
import com.me.bookreview.pojos.User;
import com.me.bookreview.validator.UserValidator;



@Controller
public class UserController {
	
	UserValidator validator;

	@RequestMapping(value="/register.htm", method=RequestMethod.POST)
//	public String register(HttpServletRequest request, HttpServletResponse response, UserDAO userdao )throws Exception {
		public ModelAndView register(@ModelAttribute("user") User user, BindingResult result, SessionStatus status, HttpServletRequest request, HttpServletResponse response, UserDAO userdao) throws Exception{
		PrintWriter out= response.getWriter();
		out.println("username");
		String username =user.getUsername().toLowerCase();
//		validator.validate(user,result);
		if(userdao.get(username)==null) {

			user.setProfileLink( "/"+username+".htm");
			System.out.println(user.getName()+" "+user.getEmail()+" "+user.getPassword()+" "+user.getUsername()+" "+user.getProfileLink());
			
			userdao.save(user);
			HttpSession session= request.getSession();
			session.setAttribute("user", user);
			return new ModelAndView("redirect:home.htm");
		}
		return new ModelAndView("error");
		
	}
	@RequestMapping(value="/login.htm", method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, UserDAO userdao)
	{
		String username =request.getParameter("username").toLowerCase();
		String password=request.getParameter("password");
		HttpSession session = request.getSession();
		User user=userdao.authenticate(username, password);
		if(user!=null)
		{
			System.out.println(user.getUsername());
			session.setAttribute("user", user);
			if(user.getRole()!=null) {
				session.setAttribute("author", "yes");
			}
			System.out.println(session.getAttribute("user"));
			return new ModelAndView("redirect:home.htm");
		}
		return new ModelAndView("error");
		
	}
	
	@RequestMapping(value="/logout.htm", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("redirect:home.htm");
	}
	
	public List<User> listAuthors(HttpServletRequest request, UserDAO userdao) {
		List<User> list=userdao.listAuthors();
		return list;
	}
	@RequestMapping(value="/addToShelf{bookid}", method=RequestMethod.GET)
	public ModelAndView addToShelf(@PathVariable int bookid, HttpServletRequest request,HttpServletResponse response, UserDAO userdao, BookDAO bookdao) throws IOException {//

		User user=(User) request.getSession().getAttribute("user");
		Book book=bookdao.getById(bookid);
		book.setReader(user);
		bookdao.update(book);
		user.addBookToReadinglist(book);
		userdao.update(user);
		return new ModelAndView("redirect:listBooks.htm");
		
	}
//	@RequestMapping(value="/removeFromShelf{bookid}", method=RequestMethod.GET)
//	public ModelAndView removeFromShelf(@PathVariable int bookid, HttpServletRequest request,HttpServletResponse response, UserDAO userdao, BookDAO bookdao) throws IOException {//
//		User user=(User) request.getSession().getAttribute("user");
//		Book book=bookdao.getById(bookid);
//		user.removeBookFromReadinglist(book);
//		userdao.update(user);
//		return new ModelAndView("redirect:listBooks.htm");
//	}
}
