/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    public static String createTitle(String title,String subtitle)
   {
	  return title+subtitle;

   }
   public static String createAuthor(String author1,String author2,String author3)
   {
	   return author1+"  "+author2+"  "+author3;
   }
   public static String createPrice(double price)
   {

	    BigDecimal number= new BigDecimal(price);
	    number = number.setScale(2, RoundingMode.HALF_UP);
	    return "$" + number.toString();
   }

    /**
     *
     * @param pubDate
     * @return
     */
    public static String createDate(Date pubDate)
   {
	   DateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
	   String text = formatDate.format(pubDate);
	   return text;
   }
   public static String createPages(int pages)
   {

	    return Integer.toString(pages)+" pages";
   }
   public static String sentenceToParagraph(String sentence)
   {
	   StringBuilder buildString = new StringBuilder(sentence);
	   int i = 0;
	   while (i + 80 < buildString.length() && (i = buildString.lastIndexOf(" ", i + 80)) != -1) {
		   buildString.replace(i, i + 1, "\n");
	   }

	  return(buildString.toString());
   }
   public static String StringReplacer(String sentence)
   {
     return sentence.replace("''", "'");
   }
   public static String getParam(FacesContext fc,String parameter)
   {

        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        return params.get(parameter);

   }
}
