package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Modele.Clients;
import Util.DBConnectionUtil;

public class Registering {
	
	public String registerUser(Clients Client)
    {         
		String res = "";
        try
        {
            Connection connection = DBConnectionUtil.openConnection();
            String query = "insert into clients(id, Email, Nom, Prenom, MotePasse, Adresse , CodePostal , Ville , Tel) values (Default, ?, ?, ?, ?,? , ? , ? , ?)"; //Insert user details into the table 'USERS'
            PreparedStatement preparedStatement = connection.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            //preparedStatement.setString(1,"Default");
            preparedStatement.setString(1, Client.getEmail());
            preparedStatement.setString(2, Client.getNom());
            preparedStatement.setString(3, Client.getPrenom());
            preparedStatement.setString(4, Client.getMotPasse());
            preparedStatement.setString(5, Client.getAdresse());
            preparedStatement.setInt(6, Client.getCodePostal());
            preparedStatement.setString(7, Client.getVille());
            preparedStatement.setInt(8, Client.getTel());
            
            int i= preparedStatement.executeUpdate();
            
            if (i!=0)  //Just to ensure data has been inserted into the database
            return res; 

        }
        catch(SQLException e)
        {
           res =  e.toString();
        }       
        return res;  // On failure, send a message from here.
    }

}
