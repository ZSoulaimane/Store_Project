package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modele.Categories;
import Util.DBConnectionUtil;

public  class CategoriesDAO {
	
	
    public static List<Categories> listCategories() throws SQLException  {
    	// using try-with-resources to avoid closing resources (boiler plate code)
    	//OuvreBase();
        List <Categories> cat = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try {
        	
        	Connection connection = DBConnectionUtil.openConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM categories"); 
            System.out.println(pstmt);
            // Step 3: Execute the query or update query
            ResultSet rs = pstmt.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int refCat = rs.getInt("RefCat");
                String catName = rs.getString("Cat");
                cat.add(new Categories(refCat, catName));
                
            
            }
            connection = null;

        } catch (SQLException e) {
        	e.printStackTrace();
        }
        //fermeBase();
        return cat;
    }
    

}
