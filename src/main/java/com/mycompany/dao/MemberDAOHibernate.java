package com.mycompany.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mycompany.Contact;
import com.mycompany.Member;


public class MemberDAOHibernate extends HibernateDaoSupport {
	protected final Log logger = LogFactory.getLog(getClass());
	
	public void insertMember(Member member) {
		logger.debug("Inside MemberDAOHibernate.insert() method");
		this.getHibernateTemplate().save(member);
	}
	
	public List getMembers() {
		logger.debug("Inside MemberDAOHibernate.getMembers() method");
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
				throws HibernateException, SQLException {

				StringBuffer sb = new StringBuffer(100);
				sb.append("select distinct member ");
				sb.append("from Member member ");
				sb.append("order by member.id");

				Query query = session.createQuery(sb.toString());
				List list = query.list();

				return list;
			}
		});		
	}
	
	public Member getContact(int id) {
		logger.debug("Inside MemberDAOHibernate.getMember() method");
		return (Member)getHibernateTemplate().get(Member.class, id);
	}
	
}
