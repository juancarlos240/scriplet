package com.tz.scriplet.service;

import com.tz.scriplet.bean.UserBean;
import com.tz.scriplet.doa.UserDAO;

public class UserService {
	private UserDAO dao;
	
	public boolean validarUsuario(UserBean user){
		dao = new UserDAO();
		return dao.validarUsuario(user);	
		
	}

}
