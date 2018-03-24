/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *This allow user to enter a title
 *since this session scope it could be used to 
 *pass parameter around
 */
package JSFCode;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Rong
 */
@Named(value="seachTitle")
@SessionScoped
public class seachTitle implements Serializable 
{   
    //variable used in code
    private String title;

    /**
     * Creates a new instance of seachTitle
     */
    public seachTitle() 
    {
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
    * method to set title
    * @param title  String
    */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
}
