package com.me.bookreview.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.me.bookreview.pojos.Book;
import com.me.bookreview.pojos.Post;
@Component
public class PostDAO extends DAO{
	  public void save(Post post){
	        begin();
	        getSession().save(post);
	        commit();
	        close();
	    }
	    public void delete(Post post){
	        begin();
	        getSession().delete(post);
	        commit();
	        close();
	    }
	    
	    public void update(Post post){
	        begin();
	        getSession().update(post);
	        commit();
	        close();
	    }
	    
//	    public Book get(String name){
//	    	try {
//	            begin();
//	            Query query=getSession().createQuery("FROM Book where name=:name");
//	            query.setParameter("name", name);
//	            Book book= (Book) query.uniqueResult();
//	            commit();
//	            return book;
//	        } catch (HibernateException e) {
//	            rollback();
//	            Logger.getAnonymousLogger().log(Level.WARNING, "Cannot close", e);
//	            return null;
//	        }
//
//	    }
	    public Post getById(int id){
	    	try {
	            begin();
	            Post post=(Post) getSession().get(Post.class,id);
	            close();
	            return post;
	        } catch (HibernateException e) {
	            rollback();
	            Logger.getAnonymousLogger().log(Level.WARNING, "Cannot close", e);
	            return null;
	        }

	    }
	    public List<Post> list(int userid) {
	    	begin();
			Query<Post> query = getSession().createQuery("FROM Post where user_userid=:user order by dateOfPost DESC");
			query.setParameter("user", userid);	
			List<Post> list = query.list();
			close();
			if(list==null)
				return null;
			return list;
		}
//	    public Set<Book>listByKeyword(String keyword){
//	    	List<Book> result= new ArrayList<Book>();
//	    	List<Book> temp= new ArrayList<Book>();
//	    	Set<Book> set= new HashSet<Book>();
//	    	String [] listOfKeywords=keyword.split(" ");
//	    	for(String str : listOfKeywords)
//	    	{
//	    		Query<Book> query = getSession().createQuery("FROM Book where author like :author or name like :name or description like :description");
//	    		query.setParameter("name", "%"+str+"%");
//	    		query.setParameter("description", "%"+str+"%");
//	    		query.setParameter("author", "%"+str+"%");
//	    		temp= query.getResultList();
//		    	result.addAll(temp);
//	    	}
//	    	for(Book b : result)
//	    		set.add(b);
//	    	return set;
//	    }

}
