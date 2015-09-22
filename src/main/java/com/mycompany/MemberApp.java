package com.mycompany;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.dao.ContactDAO;
import com.mycompany.dao.MemberDAOHibernate;

/**
 * @author testuser
 *
 */
@Component
@Path("/member")
public class MemberApp {
	protected final Log logger = LogFactory.getLog(getClass());
	private List<Member> memberList;
	@Autowired
	private MemberDAOHibernate memberDao;

	public MemberApp() {
		
	}
	
	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> contactList) {
		this.memberList = contactList;
	}
	
	public MemberDAOHibernate getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDAOHibernate contactDao) {
		this.memberDao = contactDao;
	}

	/* (non-Javadoc)
	 * @see com.sample.ContactApp#getContact(java.lang.String)
	 */
	public Member getContact(String firstName) {
		
		Member c = new Member();
		c.setUsername(firstName);
		return c;
	}

	@GET
	@Path("/jsonlist")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Member> showMemberList() {
		return memberDao.getMembers();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response createMember(Member order) {
		memberDao.insertMember( order);
		logger.debug("member created id;"+order.getId());
		return Response.status(201).entity(order).build();
    }

}
