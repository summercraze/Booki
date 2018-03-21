/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    public Book()
    {
        
    }
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
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getTitle()
    {
        return title;
    }
    public void setSubtitle(String subtitle)
    {
       this.subtitle = subtitle;
    }
    public String getSubtitle()
    {
        return subtitle;
    }
    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }
    public String getIsbn()
    {
        return isbn;
    }
    public void setAuthor1(String author1)
    {
        this.author1= author1;
    }
    public String getAuthor1()
    {
        return author1;
    }
    public void setAuthor2(String author2)
    {
        this.author2=author2;
    }
    public String getAuthor2()
    {
        return author2;
    }
    public void setAuthor3(String author3)
    {
       this.author3=author3;
    }
    public String getAuthor3()
    {
        return author3;
    }
    public void setTranslator(String translator)
    {
       this.translator=translator;  
    }
    public String getTranslator()
    {
        return translator;
    }
    public void setPrice(Double price)
    {
        this.price = price;
    }
    public Double getPrice()
    {
        return price;
    }
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }
    public String getPublisher()
    {
        return publisher;
    }
    public void setPublisherDate(Date date)
    {
        this.publisherDate = date;
    }
    public Date getPublisherDate()
    {
        return publisherDate;
    }
    public void setBookCover(String cover)
    {
        this.coverType = cover;
    }
    public String getBookCover()
    {
        return coverType;
    }
    public void setPage(int page)
    {
        this.page = page;
    }
    public int getPage()
    {
        return page;
    }
    public void setBookInfo(String bookInfo)
    {
        this.bookInfo = bookInfo;
    }
    public String getBookInfo()
    {
        return bookInfo;
    }
    public void setAboutAuthor(String authorInfo)
    {
        this.aboutAuthor = authorInfo;
    }
    public String getAboutAuthor()
    {
        return aboutAuthor;
    }
    public void setContentPage(String contentPage)
    {
            this.contentPage = contentPage;
       
    } 
    public String getContentPage()
    {
        return contentPage;
    }
}
