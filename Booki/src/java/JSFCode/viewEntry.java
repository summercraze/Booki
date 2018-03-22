/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFCode;


import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;

/**
 *
 * @author Rong
 */
@Named(value="viewEntry")
@RequestScoped
public class viewEntry implements Serializable
{
    private String title;
    /**
     * Creates a new instance of viewEntry
     */
    public viewEntry()
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
	
}
