package com.mycompany.web;

import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.Member;
import com.mycompany.dao.ContactDAO;
import com.mycompany.dao.MemberDAOHibernate;

/**
 * @author testuser
 *
 */
@Controller
@RequestMapping("/member")
public class RestfulMemberService {
	protected final Log logger = LogFactory.getLog(getClass());
	private List<Member> memberList;
	@Autowired
	private MemberDAOHibernate memberDAOHibernate;

	public RestfulMemberService() {
		
	}
	
	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> contactList) {
		this.memberList = contactList;
	}
	
	public MemberDAOHibernate getMemberDao() {
		return memberDAOHibernate;
	}

	public void setMemberDao(MemberDAOHibernate contactDao) {
		this.memberDAOHibernate = contactDao;
	}

	/* (non-Javadoc)
	 * @see com.sample.ContactApp#getContact(java.lang.String)
	 */
	public Member getContact(String firstName) {
		
		Member c = new Member();
		c.setUsername(firstName);
		return c;
	}

	@RequestMapping(value = "/jsonlist", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseEntity<List<Member>> showMemberList() {
		logger.debug("inside showmemberlist");
		return new ResponseEntity<List<Member>>(memberDAOHibernate.getMembers(), HttpStatus.OK);
	}

	@RequestMapping( method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody ResponseEntity<Object> createMember(Member order) {
		memberDAOHibernate.insertMember( order);
		logger.debug("member created id;"+order.getId());
		return new ResponseEntity<Object>(order, HttpStatus.OK);
    }

}
