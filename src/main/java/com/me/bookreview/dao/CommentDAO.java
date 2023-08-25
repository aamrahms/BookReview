package com.me.bookreview.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.me.bookreview.pojos.Comment;
import com.me.bookreview.pojos.Comment;

public class CommentDAO extends DAO{

		  public void save(Comment comment){
		        begin();
		        getSession().save( comment);
		        commit();
		        close();
		    }
		    public void delete(Comment comment){
		        begin();
		        getSession().delete( comment);
		        commit();
		        close();
		    }
		    
		    public void update(Comment comment){
		        begin();
		        getSession().update( comment);
		        commit();
		        close();
		    }
		    
//		    public Book get(String name){
//		    	try {
//		            begin();
//		            Query query=getSession().createQuery("FROM Book where name=:name");
//		            query.setParameter("name", name);
//		            Book book= (Book) query.uniqueResult();
//		            commit();
//		            return book;
//		        } catch (HibernateException e) {
//		            rollback();
//		            Logger.getAnonymousLogger().log(Level.WARNING, "Cannot close", e);
//		            return null;
//		        }
	//
//		    }
//		    public Book getById(int id){
//		    	try {
//		            begin();
//		            Book book=(Book) getSession().get(Book.class,id);
//		            commit();
//		            return book;
//		        } catch (HibernateException e) {
//		            rollback();
//		            Logger.getAnonymousLogger().log(Level.WARNING, "Cannot close", e);
//		            return null;
//		        }
	//
//		    }
		    public List<Comment> list(int userid) {
		    	begin();
				Query<Comment> query = getSession().createQuery("FROM Comment where user_userid=:user order by dateOfComment DESC");
				query.setParameter("user", userid);	
				List<Comment> list = query.list();
				close();
				if(list==null)
					return null;
				return list;
			}
//		    public List<Comment> list(int postid) {
//		    	begin();
//				Query<Comment> query = getSession().createQuery("FROM Comment where post_postid:postid");
//				query.setParameter("postid", postid);	
//				List<Comment> list = query.list();
//				close();
//				if(list==null)
//					return null;
//				return list;
//			}
//		    public Set<Book>listByKeyword(String keyword){
//		    	List<Book> result= new ArrayList<Book>();
//		    	List<Book> temp= new ArrayList<Book>();
//		    	Set<Book> set= new HashSet<Book>();
//		    	String [] listOfKeywords=keyword.split(" ");
//		    	for(String str : listOfKeywords)
//		    	{
//		    		Query<Book> query = getSession().createQuery("FROM Book where author like :author or name like :name or description like :description");
//		    		query.setParameter("name", "%"+str+"%");
//		    		query.setParameter("description", "%"+str+"%");
//		    		query.setParameter("author", "%"+str+"%");
//		    		temp= query.getResultList();
//			    	result.addAll(temp);
//		    	}
//		    	for(Book b : result)
//		    		set.add(b);
//		    	return set;
//		    }

	}

