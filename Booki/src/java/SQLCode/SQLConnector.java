/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLCode;
import java.sql.*;
/**
 *
 * @author Rong
 */
public class SQLConnector 
{
    protected static Connection conn;
	   static private SQLHelperMethod  test;
	     /**
	    * method to connect the database
	    * @throws SQLException 
	    * @throws ClassNotFoundException 
	    */
	   static private boolean connect() 
	      throws ClassNotFoundException, SQLException {
	      test = new SQLHelperMethod ("5432", "Book", "postgres","920307");
	      if (test.getConnection() == false)
	      {
	         test = new SQLHelperMethod ("5432", "Book", "postgres","920307");
	         return test.getConnection();
	      }
	      else if  (test.getConnection() == false)
	      {
	         test = new SQLHelperMethod ("5432", "Book", "postgres","920307");
	         return test.getConnection();
	      }
	      return test.getConnection();
	   }
            /**
	    * method to check title in the database
	    * @param title  first name
	    * @return            true or false
	    * @throws SQLException 
	    * @throws ClassNotFoundException 
	    */
	   static public boolean checkTitle(String title) 
	      throws ClassNotFoundException, SQLException {
	      boolean exist = false;
	      if (connect() == false)
	         System.out.println("Fail to connect");
	   
	      exist = test.confirmTitle(title);
	      return exist;
	   } 
}
