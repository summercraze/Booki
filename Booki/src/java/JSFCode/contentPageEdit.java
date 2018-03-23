/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class contentPageEdit {
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
        editedTitle = "Update content page information of " + title;
        return editedTitle;
    }
     public void setContentPage(String info)
    {
        this.contentPage = info;
    }
    public String getContentPage()
    {
        return contentPage;
    }
     public String setStatus() throws ClassNotFoundException, SQLException, ParseException
    {
        if( editContentPage(title,contentPage))
        {
            status = "Book's content page is updated. You may view it later.";    
        }
       return "confirmContentPageChange";
    }
    public String getStatus()
    {
        return status;
    }
}
