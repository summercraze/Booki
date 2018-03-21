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
public class SQLHelperMethod 
{
       public static Connection connection = null;
       private static String host;
       private static String dbName;
       private static String user;
       private static String password;
       /**
        * constructor
        * @param host
        * @param dbName    database name
        * @param user      database username
        * @param password      database password
         * @throws java.lang.ClassNotFoundException
         * @throws java.sql.SQLException
        * 
        */
       public SQLHelperMethod(String host, String dbName, String user, 
          String password)throws ClassNotFoundException, SQLException 
        {
          this.host = host;
          this.dbName = dbName;
          this.user = user;
          this.password = password;
       }
        /**
        * this checks for whether the code has a JDBC drive
        * @return true or false
        * @throws ClassNotFoundException
        */
       private static boolean checkJDBCConnetion() throws ClassNotFoundException {
          System.out.println("-------- PostgreSQL "
             + "JDBC Connection Testing ------------");

          try {
             Class.forName("org.postgresql.Driver");
          } catch (ClassNotFoundException e) {
             System.out.println("Where is your PostgreSQL JDBC Driver? "
                   + "Include in your library path!");
             e.printStackTrace();
             return false;
          }

          System.out.println("PostgreSQL JDBC Driver Registered!");
          return true;
       }

       /**
        * this connect to the actual database after checking for drive
        * @return Connection
        * @throws ClassNotFoundException,SQLException
        */
       private static Connection connect() 
          throws SQLException, ClassNotFoundException { 
          if (checkJDBCConnetion() == true) {
             try {
                connection = DriverManager.getConnection(
                   "jdbc:postgresql://localhost:" + 
                    host + "/" + dbName,user, password);
             } catch (SQLException e) {
                e.printStackTrace();
             }
          }
          return connection;
       }

       /**
        * this tells the SQL Connector method if the database is connected
        * @return boolean
        * @throws SQLException 
        * @throws ClassNotFoundException 
        * 
        */
       public boolean getConnection() throws ClassNotFoundException, SQLException
       {
          return !(connect() == null);
       }
       /**
        * this method check whether the title exist in database
        * @param title
        * @return status
        * @throws SQLException
        * @throws ClassNotFoundException 
        */
       private static int checkBook(String title)
          throws SQLException, ClassNotFoundException {
          Connection dbConnection = null;
          CallableStatement checkBookStatement = null;
          int status = 2;

          String checkTitlesql = "{call checktitle(?,?)}";
          try {
             //connect and call function
             dbConnection = connect();
            checkBookStatement = dbConnection.prepareCall(checkTitlesql);

             //put the variable into the function to execute
             checkBookStatement.setString(1, title);
             //get the output from the function
              checkBookStatement.registerOutParameter(2, java.sql.Types.INTEGER);
             // execute insertloginSqlstore procedure
              checkBookStatement.executeUpdate();
             //get the output and return it
             status =  checkBookStatement.getInt(2);

          } catch (SQLException e) {
             System.out.println(e.getMessage());

          } finally {
             if (checkBookStatement != null) {
                checkBookStatement.close();
             }

             if (dbConnection != null) {
                dbConnection.close();
             }
          }
          return status;
       }
        /**
        * this method let SQLConnector check title in database
        * @param title
        * @return boolean
        * @throws SQLException
        * @throws ClassNotFoundException 
        */
       public boolean confirmTitle(String title) 
          throws ClassNotFoundException, SQLException {
          int status;
          status = checkBook(title);
          boolean result = false;

          if (status == 0)
             result = false;

          if (status == 1)
             result = true;

          return result;
       }
       /**
     * this method insert title into the database
     * @param title
     * @param subtitle
     * @param isbn
     * @param author1
     * @param author2
     * @param author3
     * @param translator
     * @param price
     * @param publisher
     * @param publisherDate
     * @param coverType
     * @param page
     * @param bookInfo
     * @param aboutAuthor
     * @param contentPage
     * @return status
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    private static int insertBook(String title, String subtitle,
                    String isbn, String author1,  String author2,  String author3, 
                    String translator, double price,String publisher,Date publisherDate,String coverType,
                    int page,String bookInfo,String aboutAuthor, Object contentPage)
                                    throws SQLException, ClassNotFoundException 
    {
            Connection dbConnection = null;
            CallableStatement insertBookStatement = null;
            int status = 2;

            String insertTitlesql = "{call inserttitle(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            try {
                    //connect and call function
                    dbConnection = connect();
                    insertBookStatement = dbConnection.prepareCall(insertTitlesql);

                    //put the variable into the function to execute
                    insertBookStatement.setString(1, title);
                    insertBookStatement.setString(2, subtitle);
                    insertBookStatement.setString(3, isbn);
                    insertBookStatement.setString(4, author1);
                    insertBookStatement.setString(5, author2);
                    insertBookStatement.setString(6, author3);
                    insertBookStatement.setString(7, (String) translator);
                    insertBookStatement.setDouble(8, price);
                    insertBookStatement.setString(9, publisher);
                    insertBookStatement.setDate(10, publisherDate);
                    insertBookStatement.setString(11, coverType);
                    insertBookStatement.setInt(12, page);
                    insertBookStatement.setString(13, bookInfo);
                    insertBookStatement.setString(14, aboutAuthor);
                    insertBookStatement.setString(15, (String) contentPage);

                    //get the output from the function
                    insertBookStatement.registerOutParameter(16, java.sql.Types.INTEGER);
                    // execute insertloginSqlstore procedure
                    insertBookStatement.executeUpdate();
                    //get the output and return it
                    status = insertBookStatement.getInt(16);

            } catch (SQLException e) {
                    System.out.println(e.getMessage());

            } finally {
                    if (insertBookStatement != null) {
                            insertBookStatement.close();
                    }

                    if (dbConnection != null) {
                            dbConnection.close();
                    }
            }
            return status;
    }
    /**
     * this method let SQLConnector insert title in database
     * @param title
     * @param subtitle
     * @param isbn
     * @param author1
     * @param author2
     * @param author3
     * @param translator
     * @param price
     * @param publisher
     * @param publisherDate
     * @param coverType
     * @param page
     * @param bookInfo
     * @param aboutAuthor
     * @param contentPage
     * @return boolean
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public boolean insertTitle(String title, String subtitle,
                       String isbn, String author1,String author2,String author3, 
                       String translator, double price,String publisher,
                       Date publisherDate,String coverType,
                       int page,String bookInfo,String aboutAuthor,String contentPage
                         )throws ClassNotFoundException, SQLException 
    {
            int status;
            status = insertBook(title,subtitle,isbn,author1,author2,author3,translator,
                      price,publisher,publisherDate,coverType,page,
                      bookInfo,aboutAuthor,contentPage);
            boolean result = false; 
            if (status == 0)
                    result = false;

            if (status == 1)
                    result = true;

            return result;
    }

}
