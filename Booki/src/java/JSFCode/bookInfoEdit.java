/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *This allow user to edit book information
 *This control bookInformationChanged.xhtml
 *and confirmBookInfroChange.xhtml
 */

package JSFCode;

import static SQLCode.SQLConnector.editBookInfo;
import java.sql.SQLException;
import java.text.ParseException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Rong
 */
@Named(value = "bookInfoEdit")
@RequestScoped
public class bookInfoEdit 
{
    //variable of bookInfoEdit
    private String title;
    private String bookInfo;
    private String editedTitle = "";
    private String status ="Information not changed.";
    
    /**
     * Creates a new instance of bookInfoEdit
     */
    public bookInfoEdit() 
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
        return title;
    } 
    
    /**
    * method to get the sentence of output of confirmBookInfroChange.xhtml
    * @return editedTitle String
    */
    public String outputEdit()
    {
        editedTitle = "Update book information of " + title;
        return editedTitle;
    }
    
    /**
    * method to set bookInfo
    * @param info  String
    */
    public void setBookInfo(String info)
    {
        this.bookInfo = info;
    }
    
    /**
    * method to get bookInfo
    * @return bookInfo String
    */
    public String getBookInfo()
    {
        return bookInfo;
    }
    
    /**
    * method to setter for status and perform the database update and return the
    * xtml for next page
    * @return confirmBookInfroChange String
    * @throws ClassNotFoundException
    * @throws SQLException 
    * @throws ParseException
    */
    public String setStatus() throws ClassNotFoundException, SQLException, ParseException
    {
        if( editBookInfo(title,bookInfo))
        {
            status = "Book's information is updated. You may view it later.";    
        }
       return "confirmBookInfroChange";
    }
    
    /**
    * method to getter for status 
    * @return status String
    */
    public String getStatus()
    {
        return status;
    }
    
}
