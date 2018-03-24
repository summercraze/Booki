/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *This is the book object
 */
package JavaCode;

import java.sql.Date;
import java.text.ParseException;

/**
 *
 * @author Rong
 */
public class Book 
{
    //variable used in code
    private String title;
    private String subtitle;
    private String isbn;
    private String author1; 
    private String author2; 
    private String author3; 
    private String translator;
    private double price;
    private String publisher;
    private Date publisherDate;
    private String coverType;
    private int page;
    private String bookInfo;
    private String aboutAuthor;
    private String contentPage;
    
    /**
     * Creates a new instance of Book
     */
    public Book()
    {
        
    }
    
    /**
    * constructor with parameter
    * @param title  String
    * @param subtitle String
    * @param isbn String
    * @param author1 String
    * @param author2 String
    * @param author3 String
    * @param translator String
    * @param price double
    * @param publisher String
    * @param publisherDate Date
    * @param coverType String
    * @param page int
    * @param bookInfo String
    * @param aboutAuthor String
    * @param contentPage String
    */
    public Book(String title, String subtitle,String isbn, String author1,  String author2,  String author3,
            String translator, double price,String publisher,Date publisherDate,String coverType,
	    int page,String bookInfo,String aboutAuthor, String contentPage)
    {
        this.title = title;
        this.subtitle = subtitle;
        this.isbn = isbn;
        this.author1 = author1;
        this.author2 = author2;
        this.author3 = author3;
        this.translator = translator;
        this.price = price;
        this.publisher = publisher;
        this.publisherDate = publisherDate;
        this.coverType = coverType;
        this.page = page;
        this.bookInfo = bookInfo;
        this.aboutAuthor = aboutAuthor;
        this.contentPage = contentPage;
    }
    
    /**
    * method to set title 
    * @param title  String
    */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    /**
    * method to get title
    * @return title String
    */
    public String getTitle()
    {
        return title;
    }
    
    /**
    * method to set subtitle 
    * @param subtitle String
    */
    public void setSubtitle(String subtitle)
    {
       this.subtitle = subtitle;
    }
    
    /**
    * method to get subtitle
    * @return subtitle String
    */
    public String getSubtitle()
    {
        return subtitle;
    }
    
    /**
    * method to set ISBN 
    * @param isbn String
    */
    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }
    
    /**
    * method to get ISBN
    * @return isbn String
    */
    public String getIsbn()
    {
        return isbn;
    }
    
    /**
    * method to set author1 
    * @param author1 String
    */
    public void setAuthor1(String author1)
    {
        this.author1= author1;
    }
    
    /**
    * method to get author1
    * @return author1 String
    */
    public String getAuthor1()
    {
        return author1;
    }
    
    /**
    * method to set author2 
    * @param author2 String
    */
    public void setAuthor2(String author2)
    {
        this.author2=author2;
    }
    
    /**
    * method to get author2
    * @return author2 String
    */
    public String getAuthor2()
    {
        return author2;
    }
    
    /**
    * method to set author3
    * @param author3 String
    */
    public void setAuthor3(String author3)
    {
       this.author3=author3;
    }
    
    /**
    * method to get author3
    * @return author3 String
    */
    public String getAuthor3()
    {
        return author3;
    }
    
    /**
    * method to set translator 
    * @param translator String
    */
    public void setTranslator(String translator)
    {
       this.translator=translator;  
    }
    
    /**
    * method to get translator
    * @return translator String
    */
    public String getTranslator()
    {
        return translator;
    }
    
    /**
    * method to set price 
    * @param price String
    */
    public void setPrice(Double price)
    {
        this.price = price;
    }
    
    /**
    * method to get price
    * @return price Double
    */
    public Double getPrice()
    {
        return price;
    }
    
    /**
    * method to set publisher 
    * @param publisher String
    */
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }
    
    /**
    * method to get publisher
    * @return publisher String
    */
    public String getPublisher()
    {
        return publisher;
    }
    
    /**
    * method to set publisher date 
    * @param date Date
    */
    public void setPublisherDate(Date date)
    {
        this.publisherDate = date;
    }
    
    /**
    * method to get publisher date
    * @return publisherDate Date
    */
    public Date getPublisherDate()
    {
        return publisherDate;
    }
    
    /**
    * method to set cover type 
    * @param coverType String
    */
    public void setBookCover(String cover)
    {
        this.coverType = cover;
    }
    
    /**
    * method to get cover type
    * @return coverType String
    */
    public String getBookCover()
    {
        return coverType;
    }
    
    /**
    * method to set page 
    * @param page String
    */
    public void setPage(int page)
    {
        this.page = page;
    }
    
    /**
    * method to get page
    * @return page String
    */
    public int getPage()
    {
        return page;
    }
    
    /**
    * method to set book information 
    * @param bookInfo String
    */
    public void setBookInfo(String bookInfo)
    {
        this.bookInfo = bookInfo;
    }
    
    /**
    * method to get book information
    * @return bookInfo String
    */
    public String getBookInfo()
    {
        return bookInfo;
    }
    
    /**
    * method to set about author 
    * @param aboutAuthor String
    */
    public void setAboutAuthor(String authorInfo)
    {
        this.aboutAuthor = authorInfo;
    }
    
    /**
    * method to get about author 
    * @return aboutAuthor String
    */
    public String getAboutAuthor()
    {
        return aboutAuthor;
    }
    
    /**
    * method to set content page 
    * @param contentPage String
    */
    public void setContentPage(String contentPage)
    {
           this.contentPage = contentPage;      
    } 
    
    /**
    * method to get content page 
    * @return contentPage String
    */
    public String getContentPage()
    {
        return contentPage;
    }
}
