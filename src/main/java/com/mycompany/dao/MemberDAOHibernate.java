package com.mycompany.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mycompany.Contact;
import com.mycompany.Member;

@Repository
public class MemberDAOHibernate {
	protected final Log logger = LogFactory.getLog(getClass());
	
	@PersistenceContext(unitName="demoHSQLPersistence")
	private EntityManager em;
	
	public void insertMember(Member member) {
		logger.debug("Inside MemberDAOHibernate.insert() method");
		this.em.persist(member);
	}
	
	public List getMembers() {
		logger.debug("Inside MemberDAOHibernate.getMembers() method");
		TypedQuery<Member> query = this.em.createQuery("SELECT m FROM Member AS m", Member.class);
		return query.getResultList();
	}
	
	public Member getContact(int id) {
		logger.debug("Inside MemberDAOHibernate.getMember() method");
		return (Member)this.em.find(Member.class, id);
	}
	
}
