/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFCode;
import static JavaCode.usefuleCode.getParam;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author Rong
 */
@Named(value = "basicInfoEdit")
@RequestScoped
public class basicInfoEdit 
{
    private String title;
    /**
     * Creates a new instance of basicInfoEdit
     */
    public basicInfoEdit() 
    {
        
    }
    public String getResponse()
    {
		
        FacesContext fc = FacesContext.getCurrentInstance();
	this.title = getParam(fc,"title");

        return "editBasicInfo";
    }
    public String getTitle()
    {
        return title;
    }
    
}
