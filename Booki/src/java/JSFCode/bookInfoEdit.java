/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFCode;

import static SQLCode.SQLConnector.editAuthorInfo;
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
public class bookInfoEdit {
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
        editedTitle = "Update book information of " + title;
        return editedTitle;
    }
     public void setBookInfo(String info)
    {
        this.bookInfo = info;
    }
    public String getBookInfo()
    {
        return bookInfo;
    }
     public String setStatus() throws ClassNotFoundException, SQLException, ParseException
    {
        if( editBookInfo(title,bookInfo))
        {
            status = "Book's information is updated. You may view it later.";    
        }
       return "confirmBookInfroChange";
    }
    public String getStatus()
    {
        return status;
    }
    
}
