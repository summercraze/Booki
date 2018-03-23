/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLCode;

import java.sql.*;
import JavaCode.Book;

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
   private static Book book;
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
                    int page,String bookInfo,String aboutAuthor, String contentPage)
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
    /**
    * this method get the book info from database
    * @param title
    * @return boolean
    * @throws SQLException
    * @throws ClassNotFoundException 
    */

    private static boolean getBookData(String title)
             throws SQLException, ClassNotFoundException
    {
      book = new Book();
      book.setTitle(title);

      Connection dbConnection = null;
      CallableStatement getBookDataStatement = null;
      boolean success = false;
      String getBookDataSQL = "select * from getbookinfo(?)";

      try 
      {
         //connect and call function
         dbConnection = connect();
         getBookDataStatement = dbConnection.prepareCall(getBookDataSQL);

         //put the variable into the function to execute
         getBookDataStatement.setString(1, title);

         // execute insertloginSqlstore procedure
         ResultSet rs = getBookDataStatement.executeQuery();


         while (rs.next()) 
         { 
            book.setSubtitle(rs.getString(1));
            book.setIsbn(rs.getString(2));
            book.setAuthor1(rs.getString(3));
            book.setAuthor2(rs.getString(4));
            book.setAuthor3(rs.getString(5));
            book.setTranslator(rs.getString(6));
            book.setPrice(rs.getDouble(7));
            book.setPublisher(rs.getString(8));
            book.setPublisherDate(rs.getDate(9));
            book.setBookCover(rs.getString(10));
            book.setPage(rs.getInt(11));
            book.setBookInfo(rs.getString(12));
            book.setAboutAuthor(rs.getString(13));
            book.setContentPage(rs.getString(14));

         }

         success = true;
         rs.close();

      } catch (SQLException e) {
         System.out.println(e.getMessage());
      } finally {
         if (getBookDataStatement!= null) {
                 getBookDataStatement.close();
         }

         if (dbConnection != null) {
            dbConnection.close();
         }
      }
      return success;
    }
    /**
    * this method get the book info 
    * @param title
    * @return boolean
    * @throws SQLException
    * @throws ClassNotFoundException 
    */
    public Book getBook(String title) throws ClassNotFoundException, SQLException 
    {

       if (getBookData(title) == false) {
         System.out.println("Error getting dates");
       }
       return  book;
    }
   /**
         * this method update a title's basic info into the database
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
         * @return status
         * @throws SQLException
         * @throws ClassNotFoundException 
         */
        private static int updateBasicInfo(String title, String subtitle,
                        String isbn, String author1,  String author2,  String author3, 
                        String translator, double price,String publisher,Date publisherDate,String coverType,
                        int page)
                                        throws SQLException, ClassNotFoundException {
                Connection dbConnection = null;
                CallableStatement updateBookStatement = null;
                int status = 2;

                String insertTitlesql = "{call insertBasicInfo(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
                try {
                        //connect and call function
                        dbConnection = connect();
                        updateBookStatement = dbConnection.prepareCall(insertTitlesql);

                        //put the variable into the function to execute
                        updateBookStatement.setString(1, title);
                        updateBookStatement.setString(2, subtitle);
                        updateBookStatement.setString(3, isbn);
                        updateBookStatement.setString(4, author1);
                        updateBookStatement.setString(5, author2);
                        updateBookStatement.setString(6, author3);
                        updateBookStatement.setString(7, (String) translator);
                        updateBookStatement.setDouble(8, price);
                        updateBookStatement.setString(9, publisher);
                        updateBookStatement.setDate(10, publisherDate);
                        updateBookStatement.setString(11, coverType);
                        updateBookStatement.setInt(12, page);

                        //get the output from the function
                        updateBookStatement.registerOutParameter(13, java.sql.Types.INTEGER);
                        // execute insertloginSqlstore procedure
                        updateBookStatement.executeUpdate();
                        //get the output and return it
                        status = updateBookStatement.getInt(13);

                } catch (SQLException e) {
                        System.out.println(e.getMessage());

                } finally {
                        if (updateBookStatement != null) {
                                updateBookStatement.close();
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
     * @return boolean
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public boolean basicInfoUpdated(String title, String subtitle,
                    String isbn, String author1,  String author2,  String author3, 
                    String translator, double price,String publisher,Date publisherDate,String coverType,
                    int page) 
                                    throws ClassNotFoundException, SQLException {
            int status;
            status = updateBasicInfo(title,subtitle,isbn,author1,author2,author3,translator,
                            price,publisher,publisherDate,coverType,page);
            boolean result = false; 
            if (status == 0)
                    result = false;

            if (status == 1)
                    result = true;

            return result;
}
    	   /**
		 * this method update a title's basic info into the database
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
		 * @return status
		 * @throws SQLException
		 * @throws ClassNotFoundException 
		 */
		private static int updateContentPage(String title,String contentPage)
						throws SQLException, ClassNotFoundException {
			Connection dbConnection = null;
			CallableStatement updateContentPageStatement = null;
			int status = 2;

			String insertContentsql = "{call insertcontentpage(?,?,?)}";
			try {
				//connect and call function
				dbConnection = connect();
				updateContentPageStatement = dbConnection.prepareCall(insertContentsql);

				//put the variable into the function to execute
				updateContentPageStatement.setString(1, title);
				updateContentPageStatement.setString(2, contentPage);

				//get the output from the function
				updateContentPageStatement.registerOutParameter(3, java.sql.Types.INTEGER);
				// execute insertloginSqlstore procedure
				updateContentPageStatement.executeUpdate();
				//get the output and return it
				status = updateContentPageStatement.getInt(3);

			} catch (SQLException e) {
				System.out.println(e.getMessage());

			} finally {
				if (updateContentPageStatement != null) {
					updateContentPageStatement.close();
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
 * @return boolean
 * @throws SQLException
 * @throws ClassNotFoundException 
 */
public boolean contentPageUpdated(String title,String contentPage) 
				throws ClassNotFoundException, SQLException {
	int status;
	status = updateContentPage(title, contentPage);
	boolean result = false; 
	if (status == 0)
		result = false;

	if (status == 1)
		result = true;

	return result;
}
/**
	 * this method update a title's basic info into the database
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
	 * @return status
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	private static int updateAuthorInfo(String title,String authorInfo)
					throws SQLException, ClassNotFoundException {
		Connection dbConnection = null;
		CallableStatement updateAuthorStatement = null;
		int status = 2;

		String updateAuthrosql = "{call insertAuthor(?,?,?)}";
		try {
			//connect and call function
			dbConnection = connect();
			updateAuthorStatement = dbConnection.prepareCall(updateAuthrosql);

			//put the variable into the function to execute
			updateAuthorStatement.setString(1, title);
			updateAuthorStatement.setString(2, authorInfo);

			//get the output from the function
			updateAuthorStatement.registerOutParameter(3, java.sql.Types.INTEGER);
			// execute insertloginSqlstore procedure
			updateAuthorStatement.executeUpdate();
			//get the output and return it
			status = updateAuthorStatement.getInt(3);

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			if (updateAuthorStatement != null) {
				updateAuthorStatement.close();
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
* @return boolean
* @throws SQLException
* @throws ClassNotFoundException 
*/
public boolean authorInfoUpdated(String title,String authorInfo) 
			throws ClassNotFoundException, SQLException {
int status;
status = updateAuthorInfo(title, authorInfo);
boolean result = false; 
if (status == 0)
	result = false;

if (status == 1)
	result = true;

return result;
}
/**
 * this method update a title's basic info into the database
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
 * @return status
 * @throws SQLException
 * @throws ClassNotFoundException 
 */
private static int updateBookInfo(String title,String bookInfo)
				throws SQLException, ClassNotFoundException {
	Connection dbConnection = null;
	CallableStatement updateBookStatement = null;
	int status = 2;

	String updateAuthrosql = "{call insertBookInfo(?,?,?)}";
	try {
		//connect and call function
		dbConnection = connect();
		updateBookStatement = dbConnection.prepareCall(updateAuthrosql);

		//put the variable into the function to execute
		updateBookStatement.setString(1, title);
		updateBookStatement.setString(2, bookInfo);

		//get the output from the function
		updateBookStatement.registerOutParameter(3, java.sql.Types.INTEGER);
		// execute insertloginSqlstore procedure
		updateBookStatement.executeUpdate();
		//get the output and return it
		status = updateBookStatement.getInt(3);

	} catch (SQLException e) {
		System.out.println(e.getMessage());

	} finally {
		if (updateBookStatement != null) {
			updateBookStatement.close();
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
* @return boolean
* @throws SQLException
* @throws ClassNotFoundException 
*/
public boolean bookInfoUpdated(String title,String bookInfo) 
		throws ClassNotFoundException, SQLException {
int status;
status = updateBookInfo(title,bookInfo);
boolean result = false; 
if (status == 0)
result = false;

if (status == 1)
result = true;

return result;
}
}
