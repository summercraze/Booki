/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
@Named(value = "enterEntry")
@RequestScoped
public class enterEntry 
{
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
    private String status = "Nothing is stored";
    /**
     * Creates a new instance of enterEntry
     */
    public enterEntry() 
    {
        insertBook = new Book();
    }
    public void setTitle(String title)
    {
        insertBook.setTitle(title);
        this.title = title;
    }
    public String getTitle()
    {
        return title;
    }
    public void setSubtitle(String subtitle)
    {
        insertBook.setSubtitle(subtitle);
        this.subtitle = subtitle;
    }
    public String getSubtitle()
    {
        return subtitle;
    }
    public void setIsbn(String isbn)
    {
        insertBook.setIsbn(isbn);
        this.isbn = isbn;
    }
    public String getIsbn()
    {
        return isbn;
    }
    public void setAuthor1(String author1)
    {
        insertBook.setAuthor1(author1);
        this.author1 = author1;
    }
    public String getAuthor1()
    {
        return author1;
    }
    public void setAuthor2(String author2)
    {
        insertBook.setAuthor2(author2);
        this.author2 = author2;
    }
    public String getAuthor2()
    {
        return author2;
    }
    public void setAuthor3(String author3)
    {
        insertBook.setAuthor3(author3);
        this.author3 = author3;
    }
    public String getAuthor3()
    {
        return author3;
    }
    public void setTranslator(String translator)
    {
        insertBook.setTranslator(translator);
        this.translator = translator;
    }
    public String getTranslator()
    {
        return translator;
    }
    public void setPrice(String price)
    {
        insertBook.setPrice(Double.parseDouble(price));
        this.price = price;
    }
    public String getPrice()
    {
        return price;
    }
    public void setPublisher(String publisher)
    {
        insertBook.setPublisher(publisher);
        this.publisher = publisher;
    }
    public String getPublisher()
    {
        return publisher;
    }
    public void setPublisherDate(String date) throws ParseException
    {
        insertBook.setPublisherDate(changeDate(date));
        this.publisherDate = date;
    }
    public String getPublisherDate()
    {
        return publisherDate;
    }
    public void setCoverType(String coverType)
    {
        insertBook.setBookCover(coverType);
        this.coverType = coverType;
    }
    public String getCoverType()
    {
        return coverType;
    }
    public void setPage(String page)
    {
        insertBook.setPage(Integer.parseInt(page));
        this.page = page;
    }
    public String getPage()
    {
        return page;
    }
    public void setBookInfo(String bookInfo)
    {
        insertBook.setBookInfo(bookInfo);
        this.bookInfo = bookInfo;
    }
    public String getBookInfo()
    {
        return bookInfo;
    }
    public void setAboutAuthor(String aboutAuthor)
    {
        insertBook.setAboutAuthor(aboutAuthor);
        this.aboutAuthor = aboutAuthor;
    }
    public String getAboutAuthor()
    {
        return aboutAuthor;
    }
    public void setContentPage(String contentPage)
    {
        insertBook.setContentPage(contentPage);
        this.contentPage = contentPage;
    }
    public String getContentPage()
    {
        return contentPage;
    }
    public String setStatus() throws ClassNotFoundException, SQLException
    {
        if(addTitle(insertBook))
        {
            status = title + " is now registered in the database";
        }
        return "bookInsertStatus";
    }
    public String getStatus()
    {
        return status;
    }
            
}
