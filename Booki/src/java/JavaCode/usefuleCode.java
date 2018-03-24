/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *This is different class of usefuleCode
 *used in different palce
 */
package JavaCode;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
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
    /**
    * method to change string date to sql date
    * @param date  String
    * @return java.sql.Date(formatDate.getTime()) java.sql.Date
    * @throws ParseException
    */
    public static java.sql.Date changeDate(String date) throws ParseException
    {
        DateFormat  dateformat = new  SimpleDateFormat ("MM/dd/yyyy");
        java.util.Date formatDate = dateformat.parse(date);
        return new java.sql.Date(formatDate.getTime());
    }
    
    /**
    * method to add ' to sentence
    * @param sentence  String
    * @return sentence.replace("'", "''") String
    */
    public static String sqlStringReplacer(String sentence)
    {
     return sentence.replace("'", "''");
    }
    
    /**
    * method to create title and subtitle
    * @param title String
    * @param subtitle String
    * @return title+subtitle String
    */
    public static String createTitle(String title,String subtitle)
    {
          return title+subtitle;
    }
    
    /**
    * method to add all author together
    * @param author1 String
    * @param author2 String
    * @param author3 String
    * @return author1+"  "+author2+"  "+author3 String
    */
    public static String createAuthor(String author1,String author2,String author3)
    {
           return author1+"  "+author2+"  "+author3;
    }
    
    /**
    * method to return $price
    * @param price String
    * @return "$" + number.toString() String
    */
    public static String createPrice(double price)
    {
            BigDecimal number= new BigDecimal(price);
            number = number.setScale(2, RoundingMode.HALF_UP);
            return "$" + number.toString();
    }

   /**
    * method to return date as string
    * @param pubDate Date
    * @return text String
    */
    public static String createDate(Date pubDate)
    {
           DateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
           String text = formatDate.format(pubDate);
           return text;
    }
    
    /**
    * method to return page as String
    * @param page int
    * @return Integer.toString(pages)+" pages" String
    */
    public static String createPages(int pages)
    {
            return Integer.toString(pages)+" pages";
    }
    
    /**
    * method to return sentence as a nice paragraph
    * @param setence String
    * @return IbuildString.toString() String
    */
    public static String sentenceToParagraph(String sentence)
    {
           StringBuilder buildString = new StringBuilder(sentence);
           int i = 0;
           while (i + 80 < buildString.length() && (i = buildString.lastIndexOf(" ", i + 80)) != -1) {
                   buildString.replace(i, i + 1, "\n");
           }

          return(buildString.toString());
    }
    
    /**
    * method to replace '' to ' of sentence
    * @param setence String
    * @return sentence.replace("''", "'") String
    */
    public static String StringReplacer(String sentence)
    {
     return sentence.replace("''", "'");
    }
    
    /**
    * method to getParam of xhtml
    * @param parameter String
    * @param fc FacesContext
    * @return params.get(parameter) String
    */
    public static String getParam(FacesContext fc,String parameter)
    {
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get(parameter);

    }
}
