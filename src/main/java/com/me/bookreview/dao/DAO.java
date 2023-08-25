/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.bookreview.dao;


import java.util.logging.Level;

import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import org.hibernate.SessionFactory;
public class DAO {
        Configuration cfg;
        SessionFactory sf;
        Session session;
        Transaction tr;
        private static final Logger log = Logger.getAnonymousLogger();
        private static final ThreadLocal sessionThread = new ThreadLocal();
    public DAO() {
        cfg= new Configuration();
        sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
//        if(sf.openSession()!=null) {
//        	session = sf.getSessionFactory().openSession();
//        }
//        session = sf.openSession();
        
        tr=null;
    }
    public void begin(){
    	session = sf.openSession();
        tr= session.beginTransaction();
    }
    public Session getSession(){
        return session;
    }
    public void commit(){
        tr.commit();
    }
    public void close(){
        session.close();
    }
    protected void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot rollback", e);
        }
        try {
            getSession().close();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot close", e);
        }
        DAO.sessionThread.set(null);
    }
        
}
