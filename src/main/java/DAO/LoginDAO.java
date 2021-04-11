package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modele.Clients;
import Util.DBConnectionUtil;

public class LoginDAO {
	

	public static Clients checkLogin(String email, String password) throws SQLException ,ClassNotFoundException {
		
		//OuvreBase();
		
		Clients user = null;
		
		try { 
			Connection connection = DBConnectionUtil.openConnection();
			String sql = "SELECT * FROM clients WHERE Email = ? and MotePasse = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			ResultSet result = pstmt.executeQuery();
 
			if (result.next()) {
				user = new Clients();
				user.setId(result.getInt("id"));
				user.setPrenom(result.getString("Prenom"));
				user.setEmail(email);
				}
			connection = null;
			}
		catch(SQLException e) {
			e.printStackTrace();
    	   }
		
		
		return user;
		}
	}
	