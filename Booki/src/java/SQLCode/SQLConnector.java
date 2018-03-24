/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLCode;
import JavaCode.Book;
import static JavaCode.usefuleCode.sqlStringReplacer;
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
          throws ClassNotFoundException, SQLException
       {
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
     * this method let SQLConnector insert title in database
     * @param title String
     * @return exist boolean
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
       static public boolean checkTitle(String title) 
          throws ClassNotFoundException, SQLException 
       {
          boolean exist = false;
          if (connect() == false)
             System.out.println("Fail to connect");

          exist = test.confirmTitle(title);
          return exist;
       } 
        
       /**
        * method to add title in the database
        * @param book Book
        * @return exist boolean
        * @throws SQLException 
        * @throws ClassNotFoundException 
        */
       static public boolean addTitle(Book book) 
          throws ClassNotFoundException, SQLException 
       {
          boolean exist = false;
          if (connect() == false)
             System.out.println("Fail to connect");

          exist = test.insertTitle(book.getTitle(),book.getSubtitle(),book.getIsbn()
                    ,book.getAuthor1(),book.getAuthor2(),book.getAuthor3()
                    ,book.getTranslator(),book.getPrice(),book.getPublisher(),
                    book.getPublisherDate(),book.getBookCover(),book.getPage(),
                    sqlStringReplacer(book.getBookInfo()),
                    sqlStringReplacer(book.getAboutAuthor()),
                    sqlStringReplacer(book.getContentPage()));
          return exist;
       }
        
       /**
        * this method get the book info 
        * @param title String
        * @return book Book
        * @throws SQLException
        * @throws ClassNotFoundException 
        */
       static public Book getBookInfo(String title) 
          throws ClassNotFoundException, SQLException {
          if (connect() == false)
             System.out.println("Fail to connect");

          Book newBook = test.getBook(title);
          return newBook;
       } 
    
      /**
     * this method let SQLConnector insert basic info in database
     * @param title String
     * @param subtitle String
     * @param isbn    String
     * @param author1 String
     * @param author2 String
     * @param author3 String
     * @param translator String
     * @param price String
     * @param publisher String
     * @param publisherDate String
     * @param coverType String
     * @param page String
     * @return result boolean
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
       static public boolean editBasicInfo(String title, String subtitle,
                            String isbn, String author1,  String author2,  String author3, 
                            String translator, double price,String publisher,Date publisherDate,String coverType,
                            int page) 
          throws ClassNotFoundException, SQLException {
          boolean exist = false;
          if (connect() == false)
             System.out.println("Fail to connect");

          exist = test.basicInfoUpdated(title,subtitle,isbn,author1,author2,author3,translator,
                      price,publisher,publisherDate,coverType,page);
          return exist;
       } 

     /**
     * this method let SQLConnector insert content page in database
     * @param title        String
     * @param contentPage  String
     * @return result      boolean
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
       static public boolean editContentPage(String title,String contentPage) 
          throws ClassNotFoundException, SQLException {
          boolean exist = false;
          if (connect() == false)
             System.out.println("Fail to connect");

          exist = test.contentPageUpdated(title,contentPage);
          return exist;
       }
        
        /**
        * this method let SQLConnector insert author information in database
        * @param title        String
        * @param authorInfo   String
        * @return result      boolean
        * @throws SQLException
        * @throws ClassNotFoundException 
        */
       static public boolean editAuthorInfo(String title,String authorInfo) 
          throws ClassNotFoundException, SQLException {
          boolean exist = false;
          if (connect() == false)
             System.out.println("Fail to connect");

          exist = test.authorInfoUpdated(title,authorInfo);
          return exist;
       } 
       
       /**
        * this method let SQLConnector update book info
        * @param title  String
        * @param bookInfo  String
        * @return result boolean
        * @throws SQLException
        * @throws ClassNotFoundException 
        */
       static public boolean editBookInfo(String title,String bookInfo) 
          throws ClassNotFoundException, SQLException {
          boolean exist = false;
          if (connect() == false)
             System.out.println("Fail to connect");

          exist = test.bookInfoUpdated(title,bookInfo);
          return exist;
       }
}
