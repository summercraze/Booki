/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFCode;
import JavaCode.Book;
import static JavaCode.usefuleCode.changeDate;
import static JavaCode.usefuleCode.getParam;
import SQLCode.SQLConnector;
import static SQLCode.SQLConnector.addTitle;
import static SQLCode.SQLConnector.editBasicInfo;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author Rong
 */
@Named(value = "basicInfoEdit")
@RequestScoped
public class basicInfoEdit 
{

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
    private String status = "Failed to change";
    /**
     * Creates a new instance of basicInfoEdit
     */
    public basicInfoEdit() 
    {
        
    }
    public void setTitle(String title)
    {
        
        this.title = title;
    }
    public String getTitle()
    {
        return "Edit information of "+title;
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
   
        this.author1 = author1;
    }
    public String getAuthor1()
    {
        return author1;
    }
    public void setAuthor2(String author2)
    {

        this.author2 = author2;
    }
    public String getAuthor2()
    {
        return author2;
    }
    public void setAuthor3(String author3)
    {

        this.author3 = author3;
    }
    public String getAuthor3()
    {
        return author3;
    }
    public void setTranslator(String translator)
    {
  
        this.translator = translator;
    }
    public String getTranslator()
    {
        return translator;
    }
    public void setPrice(String price)
    {
  
        this.price = price;
    }
    public String getPrice()
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
    public void setPublisherDate(String date) 
    {
  
        this.publisherDate = date;
    }
    public String getPublisherDate()
    {
        return publisherDate;
    }
    public void setCoverType(String coverType)
    {

        this.coverType = coverType;
    }
    public String getCoverType()
    {
        return coverType;
    }
    public void setPage(String page)
    {

        this.page = page;
    }
    public String getPage()
    {
        return page;
    }
    public String setStatus() throws ClassNotFoundException, SQLException, ParseException
    {
        if(editBasicInfo(title,subtitle,isbn, author1, author2,
                author3,translator,Double.parseDouble(price),publisher,changeDate(publisherDate),
                coverType,Integer.parseInt(page)) )
        {
            status = "The updated information is saved to database.You can come back and check it later.Thank you for help";
        }
        return "basicInfoChange";
    }
    public String getStatus()
    {
        return status;
    }
    
}
