package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modele.Articles;
import Util.DBConnectionUtil;

public class ArticlesDAO {
	

    public static List<Articles> listProducts() throws SQLException  {

        List < Articles > product = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try {
        	
        	Connection connection = DBConnectionUtil.openConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM articles");
            System.out.println(preparedStatement);
			System.out.println("I am connected");
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int CodeArticle = rs.getInt("CodeArticle");
                String Designation = rs.getString("designation");
                String Photo = rs.getString("photo");
                int Prix = rs.getInt("Prix");
                int Categorie = rs.getInt("Categorie");
                int stock = rs.getInt("Stock");
                product.add(new Articles(CodeArticle, Designation, Photo,Prix, stock, Categorie));
                
            }
            
            connection = null;

        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return product;
    }
    
    public static Articles getArticle(int id) throws SQLException  {
    	
    	Articles article = null;
    	
        try {
        	
        	Connection connection = DBConnectionUtil.openConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM articles where CodeArticle = ?");
            preparedStatement.setInt(1,id);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int CodeArticle = rs.getInt("CodeArticle");
                String Designation = rs.getString("designation");
                String Photo = rs.getString("photo");
                int Prix = rs.getInt("Prix");
                int stock = rs.getInt("Stock");
                int categorie = rs.getInt("Categorie");
                article = new Articles(CodeArticle,Designation,Photo,Prix,stock, categorie);
            }
            
            connection = null;

        } catch (SQLException e) {
        	e.printStackTrace();
        }
        
        return article;
    }
	
}
