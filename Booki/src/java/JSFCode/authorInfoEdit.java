/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *This allow user to edit the user information
 *This control authorInformationChanged.xhtml
 *and confirmAuthorInfoChange.xhtml
 *
 */
package JSFCode;

import static SQLCode.SQLConnector.editAuthorInfo;
import java.sql.SQLException;
import java.text.ParseException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Rong
 */
@Named(value = "authorInfoEdit")
@RequestScoped
public class authorInfoEdit
{
    //this is the variable used in class
    private String title;
    private String authorInfo;
    private String editedTitle = "";
    private String status ="Information not changed.";
    /**
     * Creates a new instance of authorInfoEdit
     */
    public authorInfoEdit() 
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
    * method to get the sentence of output of confirmAuthorInfoChange.xhtml 
    * @return editedTitle String
    */
    public String outputEdit()
    {
        editedTitle = "Update author information of " + title;
        return editedTitle;
    }
    
    /**
    * method to set author information
    * @param info  String
    */
     public void setAuthorInfo(String info)
    {
        this.authorInfo = info;
    }
     
    /**
    * method to get author information
    * @return authorInfo String
    */
    public String getAuthorInfo()
    {
        return authorInfo;
    }
    
    /**
    * method to setter for status and perform the database update and return the
    * xtml for next page
    * @return confirmAuthorInfoChange String
    * @throws ClassNotFoundException
    * @throws SQLException 
    * @throws ParseException
    */
    public String setStatus() throws ClassNotFoundException, SQLException, ParseException
    {
        if( editAuthorInfo(title,authorInfo))
        {
            status = "Book's author information is updated. You may view it later.";    
        }
       return "confirmAuthorInfoChange";
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
