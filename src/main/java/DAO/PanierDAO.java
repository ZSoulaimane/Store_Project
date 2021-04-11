package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashSet;

import Modele.Clients;
import Util.DBConnectionUtil;
import jakarta.servlet.http.HttpSession;

public class PanierDAO {

	static Connection connection = DBConnectionUtil.openConnection();
	PreparedStatement pstmt=null;
	Statement stmt=null;
	
	
	static SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
	static Date date = new Date(System.currentTimeMillis());
	
	public static void AjouteCommande(HttpSession session) {
		try {
			if(connection == null) {
				connection = DBConnectionUtil.openConnection();
			}
			Clients user = new Clients();
			user = (Clients) session.getAttribute("Clients");
            String query = "insert into commandes values (Default, ?, ?)"; //Insert user details into the table 'USERS'
            PreparedStatement preparedStatement = connection.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2,formatter.format(date));
            
            preparedStatement.executeUpdate();
            
            connection = null;

        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }       
    }
	
	public static int GetLastCmdId() {
		try {
			if(connection == null) {
				connection = DBConnectionUtil.openConnection();
			}
            String query = "SELECT * from commandes order by NumCommande DESC LIMIT 1"; //Insert user details into the table 'USERS'
            PreparedStatement preparedStatement = connection.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            
            
            ResultSet result = preparedStatement.executeQuery();
            
            if (result.next()) {
				
				return result.getInt("NumCommande");
				}
            
            connection = null;
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }
		return 0;       
    }
	
	public static void AjouteCommandeP(int id,HttpSession session) {
		try {
			if(connection == null) {
				connection = DBConnectionUtil.openConnection();
			}
			List<Integer> list = new ArrayList<Integer>();
			list = (List<Integer>)session.getAttribute("panier");
            String query = "insert into lignecommandes values "; //Insert user details into the table 'USERS'
             //Making use of prepared statements here to insert bunch of data

            HashSet<Integer> hSetNumbers = new HashSet(list);
            for(int i : hSetNumbers) {
            	query = query + "("+ id + ","+ i +","+Collections.frequency(list,i)+"),";
            }
            query = query.substring(0,query.length() - 1) + ";";
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.executeUpdate();
            
            connection = null;

        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }       
    }
}