/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *This allow user to edit basic information
 *This control basicInfoChange.xhtml
 *and basicInfoChange.xhtml
 *
 */

package JSFCode;
import static JavaCode.usefuleCode.changeDate;
import static SQLCode.SQLConnector.editBasicInfo;
import java.sql.SQLException;
import java.text.ParseException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


/**
 *
 * @author Rong
 */
@Named(value = "basicInfoEdit")
@RequestScoped
public class basicInfoEdit 
{
    //variable used in program
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
        return "Edit information of "+title;
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
    * method to set author2
    * @param author2 String
    */
    public void setAuthor2(String author2)
    {
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
    * method to set author3
    * @param author3 String
    */
    public void setAuthor3(String author3)
    {
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
    * method to set translator
    * @param translator String
    */
    public void setTranslator(String translator)
    {
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
    * method to set price
    * @param price String
    */
    public void setPrice(String price)
    { 
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
    * @param date String
    */
    public void setPublisherDate(String date) 
    { 
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
    * method to set cover type
    * @param coverType String
    */
    public void setCoverType(String coverType)
    {
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
    * method to set page
    * @param page String
    */
    public void setPage(String page)
    {
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
    * method to set status and perform updating database
    * @return basicInfoChange String
    * @throws ClassNotFoundException
    * @throws SQLException
    * @throws ParseException
    */
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
    
    /**
    * method to get status 
    * @return status String
    */
    public String getStatus()
    {
        return status;
    }
    
}
