/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFCode;

import SQLCode.SQLConnector;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;

/**
 *
 * @author Rong
 */
@Named(value = "seachTitle")
@SessionScoped
public class seachTitle implements Serializable 
{
    private String title;

    /**
     * Creates a new instance of seachTitle
     */
    public seachTitle() 
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
