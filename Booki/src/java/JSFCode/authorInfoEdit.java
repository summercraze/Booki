/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFCode;

import static SQLCode.SQLConnector.editAuthorInfo;
import static SQLCode.SQLConnector.editContentPage;
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
public class authorInfoEdit {
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
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getTitle()
    {
        return title;
    } 
    public String outputEdit()
    {
        editedTitle = "Update author information of " + title;
        return editedTitle;
    }
     public void setAuthorInfo(String info)
    {
        this.authorInfo = info;
    }
    public String getAuthorInfo()
    {
        return authorInfo;
    }
     public String setStatus() throws ClassNotFoundException, SQLException, ParseException
    {
        if( editAuthorInfo(title,authorInfo))
        {
            status = "Book's author information is updated. You may view it later.";    
        }
       return "confirmAuthorInfoChange";
    }
    public String getStatus()
    {
        return status;
    }
    
}
