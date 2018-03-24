/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To search book give output
 * this control index.xhtml
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
    //variable used in this code
    private String title;

    /**
     * Creates a new instance of seachTitle
     */
    public searchBooks() 
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
    * method to direct the html page to be shown and perform database
    * @return viewBook String
    * @return addBook String
    * @throws ClassNotFoundException
    * @throws SQLException
    * @throws ParseException
    */
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
