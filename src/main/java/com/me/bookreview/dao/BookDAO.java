package com.me.bookreview.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;


import com.me.bookreview.pojos.Book;
import com.me.bookreview.pojos.User;
import org.springframework.stereotype.Component;
@Component
//@Transactional
public class BookDAO extends DAO{
	  public void save(Book book){
	        begin();
	        getSession().save(book);
	        commit();
	        close();
	    }
	    public void delete(Book book){
	        begin();
	        getSession().delete(book);
	        commit();
	        close();
	    }
	    
	    public void update(Book book){
	        begin();
	        getSession().update(book);
	        commit();
	        close();
	    }
	    
	    public Book get(String name){
	    	try {
	            begin();
	            Query query=getSession().createQuery("FROM Book where name=:name");
	            query.setParameter("name", name);
	            Book book= (Book) query.uniqueResult();
//	            commit();
	            close();
	            return book;
	        } catch (HibernateException e) {
	            rollback();
	            Logger.getAnonymousLogger().log(Level.WARNING, "Cannot close", e);
	            return null;
	        }

	    }
	    public Book getById(int id){
	    	try {
	            begin();
	            Book book=(Book) getSession().get(Book.class,id);
//	            commit();
	            close();
	            return book;
	        } catch (HibernateException e) {
	            rollback();
	            Logger.getAnonymousLogger().log(Level.WARNING, "Cannot close", e);
	            return null;
	        }

	    }
	    public List<Book> list() {
	    	begin();
			Query<Book> query = getSession().createQuery("FROM Book");
			List<Book> list = query.list();
			close();
			return list;
		}
	    public Set<Book>listByKeyword(String keyword){
	    	begin();
	    	List<Book> result= new ArrayList<Book>();
	    	List<Book> temp= new ArrayList<Book>();
	    	Set<Book> set= new HashSet<Book>();
	    	String [] listOfKeywords=keyword.split(" ");
	    	for(String str : listOfKeywords)
	    	{
	    		Query<Book> query = getSession().createQuery("FROM Book where name like :name or description like :description or author_userid =(Select userid From User where name like :author)");
	    		query.setParameter("name", "%"+str+"%");
	    		query.setParameter("description", "%"+str+"%");
//	    		
	    		query.setParameter("author", "%"+str+"%");
	    		temp= query.list();
		    	result.addAll(temp);
	    	}
	    	for(Book b : result)
	    		set.add(b);
	    	close();
	    	return set;
	    }

}
