/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFCode;

import SQLCode.SQLConnector;
import java.io.Serializable;
import java.sql.SQLException;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Rong
 */
@Named(value="searchBooks")
@ViewScoped
public class searchBooks implements Serializable 
{

    private String title;

    /**
     * Creates a new instance of seachTitle
     */
    public searchBooks() 
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
    public String processSearch() throws ClassNotFoundException, SQLException
    {
        if(SQLConnector.checkTitle(title))
        {
             return "viewBook";
        }
        else
        {
            return "addBook";
        }
    }
    
}
