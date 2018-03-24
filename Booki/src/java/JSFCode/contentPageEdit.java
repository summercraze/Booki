/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *This allow user to edit content page
 *This control contentPageChanged.xhtml
 *and confirmContentPageChange.xhtml
 */
package JSFCode;

import static SQLCode.SQLConnector.editContentPage;
import java.sql.SQLException;
import java.text.ParseException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Rong
 */
@Named(value = "contentPageEdit")
@RequestScoped
public class contentPageEdit 
{
    //variable used in the program
    private String title;
    private String contentPage;
    private String editedTitle = "";
    private String status ="Information not changed.";
    
    /**
     * Creates a new instance of contentPageEdit
     */
    public contentPageEdit() 
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
        editedTitle = "Update content page information of " + title;
        return editedTitle;
    }
    
    /**
    * method to set content page
    * @param info  String
    */
    public void setContentPage(String info)
    {
        this.contentPage = info;
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
    * method to setter for status and perform the database update and return the
    * xtml for next page
    * @return confirmContentPageChange String
    * @throws ClassNotFoundException
    * @throws SQLException 
    * @throws ParseException
    */
    public String setStatus() throws ClassNotFoundException, SQLException, ParseException
    {
        if( editContentPage(title,contentPage))
        {
            status = "Book's content page is updated. You may view it later.";    
        }
       return "confirmContentPageChange";
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
