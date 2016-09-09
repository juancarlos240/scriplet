package com.tz.scriplet.doa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tz.scriplet.bean.UserBean;

public class UserDAO {
	private JDBCExample connectionFactory;
	
	
	
	public boolean validarUsuario(UserBean user){
		boolean usuarioValido = false;
		connectionFactory = new JDBCExample();
		try {
			Connection con = connectionFactory.generarConexion();
			String query="Select * from Usuario";
			Statement s = con.createStatement(); 
			ResultSet result = s.executeQuery(query);
			while(result.next()){
				if(result.getString(2).equals(user.getName())){
					usuarioValido = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarioValido;
	}
	
	

}
