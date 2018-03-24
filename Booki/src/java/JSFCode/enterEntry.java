/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *This allow user to enter entry
 *This control addEntry.xhtml
 *and bookInsertStatus.xhtml
 */
package JSFCode;

import JavaCode.Book;
import static JavaCode.usefuleCode.changeDate;
import static SQLCode.SQLConnector.addTitle;
import java.text.ParseException;
import java.sql.SQLException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Rong
 */
@Named(value="enterEntry")
@RequestScoped
public class enterEntry 
{
    //variable used in code
    private Book insertBook;
    private String title;
    private String subtitle;
    private String isbn;
    private String author1; 
    private String author2; 
    private String author3; 
    private String translator;
    private String price;
    private String publisher;
    private String publisherDate;
    private String coverType;
    private String page;
    private String bookInfo;
    private String aboutAuthor;
    private String contentPage;
    private String status = "Nothing is updated.";
    
    /**
     * Creates a new instance of enterEntry
     */
    public enterEntry() 
    {
        insertBook = new Book();
    }
    
    /**
    * method to set title and set a property of a book
    * @param title  String
    */
    public void setTitle(String title)
    {
        insertBook.setTitle(title);
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
    * method to set subtitle and set property of a book
    * @param subtitle String
    */
    public void setSubtitle(String subtitle)
    {
        insertBook.setSubtitle(subtitle);
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
    * method to set ISBN and set property of a book
    * @param isbn String
    */
    public void setIsbn(String isbn)
    {
        insertBook.setIsbn(isbn);
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
    * method to set author1 and set property of a book
    * @param author1 String
    */
    public void setAuthor1(String author1)
    {
        insertBook.setAuthor1(author1);
        this.author1 = author1;
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
    * method to set author2 and set property of a book
    * @param author2 String
    */
    public void setAuthor2(String author2)
    {
        insertBook.setAuthor2(author2);
        this.author2 = author2;
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
    * method to set author3 and set property of a book
    * @param author3 String
    */
    public void setAuthor3(String author3)
    {
        insertBook.setAuthor3(author3);
        this.author3 = author3;
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
    * method to set translator and set property of a book
    * @param translator String
    */
    public void setTranslator(String translator)
    {
        insertBook.setTranslator(translator);
        this.translator = translator;
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
    * method to set price and set property of a book
    * @param price String
    */
    public void setPrice(String price)
    {
        insertBook.setPrice(Double.parseDouble(price));
        this.price = price;
    }
    
    /**
    * method to get price
    * @return price String
    */
    public String getPrice()
    {
        return price;
    }
    
    /**
    * method to set publisher and set property of a book
    * @param publisher String
    */
    public void setPublisher(String publisher)
    {
        insertBook.setPublisher(publisher);
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
    * method to set publisher date and set property of book
    * @param date String
    * @throws java.text.ParseException
    */
    public void setPublisherDate(String date) throws ParseException
    {
        insertBook.setPublisherDate(changeDate(date));
        this.publisherDate = date;
    }
    
    /**
    * method to get publisher date
    * @return publisherDate String
    */
    public String getPublisherDate()
    {
        return publisherDate;
    }
    
    /**
    * method to set cover type and set property of book
    * @param coverType String
    */
    public void setCoverType(String coverType)
    {
        insertBook.setBookCover(coverType);
        this.coverType = coverType;
    }
    
    /**
    * method to get cover type
    * @return coverType String
    */
    public String getCoverType()
    {
        return coverType;
    }
    
    /**
    * method to set page and set property of book
    * @param page String
    */
    public void setPage(String page)
    {
        insertBook.setPage(Integer.parseInt(page));
        this.page = page;
    }
    
    /**
    * method to get page
    * @return page String
    */
    public String getPage()
    {
        return page;
    }
    
    /**
    * method to set book information and set property of a book
    * @param bookInfo String
    */
    public void setBookInfo(String bookInfo)
    {
        insertBook.setBookInfo(bookInfo);
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
    * method to set about author and set property of a book
    * @param aboutAuthor String
    */
    public void setAboutAuthor(String aboutAuthor)
    {
        insertBook.setAboutAuthor(aboutAuthor);
        this.aboutAuthor = aboutAuthor;
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
    * method to set content page and set property of a book
    * @param contentPage String
    */
    public void setContentPage(String contentPage)
    {
        insertBook.setContentPage(contentPage);
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
    
    /**
    * method to set status and perform updating database
    * @return bookInsertStatus String
    * @throws ClassNotFoundException
    * @throws SQLException
    * @throws ParseException
    */
    public String setStatus() throws ClassNotFoundException, SQLException
    {
        if(addTitle(insertBook))
        {
            status = "The book has been included in our database,you can come back and check it later.Thank you for your help!";
        }
        return "bookInsertStatus";
    }
    
    /**
    * method to get status 
    * @return status String
    */
    public String getStatus()
    {
        return status;
    }
            
}
