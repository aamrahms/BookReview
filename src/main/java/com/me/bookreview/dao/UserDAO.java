/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.bookreview.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.me.bookreview.pojos.Book;
import com.me.bookreview.pojos.User;

/**
 *
 * @author aamrah
 */
import org.springframework.stereotype.Component;
@Component
@Transactional
public class UserDAO extends DAO{
    public void save(User user){
        begin();
        getSession().save(user);
        commit();
        close();
    }
    public void delete(User user){
        begin();
        getSession().delete(user);
        commit();
        close();
    }
    
    public void update(User user){
        begin();
        getSession().update(user);
        commit();
        close();
    }
    
    public User get(String username){
    	try {
    		begin();
            Query query=getSession().createQuery("FROM User where username=:username");
            query.setParameter("username", username);
            User user= (User) query.uniqueResult();
            close();
            return user;
        } catch (HibernateException e) {
            rollback();
            Logger.getAnonymousLogger().log(Level.WARNING, "Cannot close", e);
            return null;
        }

    }
    public User get(int id){
    	try {
    		begin();
	        User user=(User) getSession().get(User.class,id);
	        close();
	        return user; 
        } catch (HibernateException e) {
            rollback();
            Logger.getAnonymousLogger().log(Level.WARNING, "Cannot close", e);
            return null;
        }
    }
    public User authenticate(String username, String password){
    	User user=this.get(username);
        if(user==null)
        	return null;
        System.out.println("not null");
        if(user.getPassword().equals(password))
        	return user;
        return null;
//        return user;
    }
    public List<User> listAuthors(){
    	begin();
    	Query<User> query = getSession().createQuery("FROM User where role is not null");
		List<User> list = query.list();
		close();
		return list;
    }
}
