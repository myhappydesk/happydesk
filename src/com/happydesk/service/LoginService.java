/**
 * 
 */
package com.happydesk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happydesk.dao.UserDao;
import com.happydesk.entity.User;
import com.happydesk.util.HappyDeskException;

/**
 * @author Apple
 *
 */

@Service
public class LoginService {
	
	@Autowired
	private UserDao userDao;
	
	public boolean authenticate(String email,String password){
		
		try {
			User user=userDao.findByEmailAndPassword(email,password);
			if(user.getEmail()!= null && user.getEmail() != null && user.getEmail().equals(email.trim()) && user.getPassword() != null && user.getPassword().equals(password.trim()) ){
				return true;
			}else{
				return false;
			}
		} catch (HappyDeskException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
