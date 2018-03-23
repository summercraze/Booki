/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFCode;

import static JavaCode.usefuleCode.changeDate;
import static JavaCode.usefuleCode.getParam;
import static SQLCode.SQLConnector.editBasicInfo;
import static SQLCode.SQLConnector.editContentPage;
import java.sql.SQLException;
import java.text.ParseException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rong
 */
@Named(value = "otherEdit")
@RequestScoped
public class otherEdit {
    private String title;
    private int output;
    private String editedInformation;
    private String editedTitle = "";
    private String status ="Information not changed.";
    /**
     * Creates a new instance of otherEdit
     */
    public otherEdit() 
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
        if(output == 1)
        {
            editedTitle = "Edit content page of " + title;
        }
        else if(output==2)
        {
           editedTitle = "Edit book information of " + title;       
        }
        else if(output ==3)
        {
            editedTitle = "Edit author information of " + title; 
        }
        return editedTitle;
    }
    public void setEditedInformation(String info)
    {
        this.editedInformation = info;
    }
    public String getEditedInformation()
    {
        return editedInformation;
    }
     public String setStatus() throws ClassNotFoundException, SQLException, ParseException
    {
        if(output==1)
        {
            editContentPage(title,editedInformation);
            status = "Information is updated.";
            return "otherInfoChanged";
        }
       return null;
    }
    public String getStatus()
    {
        return status;
    }
}
