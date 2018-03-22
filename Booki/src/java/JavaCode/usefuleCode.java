/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import javax.faces.context.FacesContext;
/**
 *
 * @author Rong
 */
public class usefuleCode 
{
    public static java.sql.Date changeDate(String date) throws ParseException
    {
        DateFormat  dateformat = new  SimpleDateFormat ("MM/dd/yyyy");
	java.util.Date formatDate = dateformat.parse(date);	
	return new java.sql.Date( formatDate.getTime()); 
    }
   public static String sqlStringReplacer(String sentence) 
   {
     return sentence.replace("'", "''");
   }
   public static String getParam(FacesContext fc,String param)
   {

        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get(param);		
    }
}
