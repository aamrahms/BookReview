package com.me.bookreview.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.me.bookreview.dao.BookDAO;
import com.me.bookreview.dao.UserDAO;
import com.me.bookreview.pojos.Book;
import com.me.bookreview.pojos.User;
@Controller
public class BookController {
	@RequestMapping(value="/addBook.htm", method=RequestMethod.POST)
		public ModelAndView addBook(@ModelAttribute("book") Book book, BindingResult result, SessionStatus status, HttpServletRequest request, HttpServletResponse response, BookDAO bookdao, UserDAO userdao) throws Exception{
		PrintWriter out= response.getWriter();
		out.println("username");
		String fileName="img"+System.currentTimeMillis()+"-"+ new Random().nextInt(10000)+ new Random().nextInt(10000)+".jpg";
//		
		book.setImage(fileName);
		int author=Integer.parseInt(request.getParameter("author"));
		User authorObj=userdao.get(author);
		book.setAuthor(authorObj);
		
//		String username =user.getUsername().toLowerCase();
//		validator.validate(user,result);
		
		if(bookdao.get(book.getName())==null) {

			bookdao.save(book);
			try {
				out.println("before file transfer");
				out.println("this is ="+book.getImageFile());
				book.getImageFile().transferTo(new File("/Users/aamrah/Downloads/bookreview/src/main/webapp/images/"+fileName));
				out.println("after file transfer");
			}
			catch(IllegalStateException e) {
				System.out.println("IllegalStateException: " + e.getMessage());
			}
			authorObj.addBookToPublishedlist(book);
			userdao.update(authorObj);
			return new ModelAndView("redirect:home.htm");
		}
		return new ModelAndView("error");
		
	}
	
	@RequestMapping(value="/listBooks.htm", method=RequestMethod.GET)
	public String listBookGet(HttpServletRequest request, BookDAO bookdao, ModelMap model) {

		List<Book> books=bookdao.list();
		request.setAttribute("books", books );
		
//		model.addAttribute("author", authors);
//		System.out.println(authors);
		return "listBooks";
	}
	

	@RequestMapping(value="/searchBook.htm", method=RequestMethod.POST)
	public String searchBook(HttpServletRequest request, BookDAO bookdao) {
		String keyword= request.getParameter("keyword");
		Set<Book> books=bookdao.listByKeyword(keyword);
		request.setAttribute("books", books );
		return "listBooks";
	}
	@ResponseBody
	@RequestMapping(value="/editBook.htm{id}", method=RequestMethod.GET)
	public Book editBook(@PathVariable int id,HttpServletRequest request, @ModelAttribute("book") Book book,BookDAO bookdao, ModelMap model) {
//		Book book= (Book) bookdao.getById(id);
		bookdao.update(book);
		model.addAttribute("book", book );
		return book;
	}
	@RequestMapping(value="/deleteBook{id}", method=RequestMethod.GET)
	public String deleteBook(@PathVariable int id,HttpServletRequest request, BookDAO bookdao) {
		Book book=bookdao.getById(id);
		bookdao.delete(book);
		return "listBooks";
	}
	
}
