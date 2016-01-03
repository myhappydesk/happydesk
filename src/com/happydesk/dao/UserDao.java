/**
 * 
 */
package com.happydesk.dao;

import java.util.List;

import javax.persistence.Query;

import com.happydesk.entity.User;
import com.happydesk.util.HappyDeskException;



/**
 * @author Manu
 *
 */
public class UserDao extends GenericDao<Integer, User>{
	
	private static final long serialVersionUID = -7182474704310999245L;

	public String  getUserInfo(String email){
		
		return "success";
		
	}
	
	
	@SuppressWarnings("unchecked")
	public User findByEmailAndPassword(String email, String password) throws HappyDeskException{
		Query jpaQuery = getEntityManager().createQuery("Select u from User u where u.email = :email and u.password = :password");
		jpaQuery.setParameter("email", email);
		jpaQuery.setParameter("password", password);
		List<User> list=jpaQuery.getResultList();
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	public User findByUserId(Integer userId) throws HappyDeskException{
		Query jpaQuery = getEntityManager().createQuery("Select u from User u where u.id  = " + userId );
		List<User> list=jpaQuery.getResultList();
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	
	public List<User> getAllUser() throws HappyDeskException{
		Query jpaQuery = getEntityManager().createQuery("select u from User u"  );
		List<User> list=jpaQuery.getResultList();
		
		return list;
	}
	
	
}
