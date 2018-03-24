/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *This allow user to viewBook
 *This control bookViewer.xhtml
 */
package JSFCode;

import JavaCode.Book;
import static JavaCode.usefuleCode.*;
import static SQLCode.SQLConnector.getBookInfo;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.sql.SQLException;

/**
 *
 * @author Rong
 */
@Named(value="viewEntry")
@RequestScoped
public class viewEntry 
{
    //variable used in this code
    private String title = " ";
    private Book viewBook;
    
    /**
     * Creates a new instance of viewEntry
     */
    public viewEntry()
    {
        
    }
    
    /**
    * method to set title and perform search to get book information
    * @throws ClassNotFoundException
    * @throws SQLException
    * @throws ParseException
    */
    public void setTitle(String title) throws ClassNotFoundException, SQLException
    {
        this.title = title;
        viewBook = getBookInfo(title);
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
    * method to get subtitle
    * @return viewBook.getSubtitle() String
    */
    public String getSubtitle()
    {
        return viewBook.getSubtitle();
    }
    
    /**
    * method to get isbn
    * @return viewBook.getIsbn() String
    */
    public String getISBN()
    {
        return viewBook.getIsbn();
    }
    
    /**
    * method to get author
    * @return createAuthor(viewBook.getAuthor1(),viewBook.getAuthor2(),viewBook.getAuthor3()) String
    */
    public String getAuthors()
    {
        return createAuthor(viewBook.getAuthor1(),viewBook.getAuthor2(),viewBook.getAuthor3());
    }
    
    /**
    * method to get translator
    * @return viewBook.getTranslator() String
    */
    public String getTranslator()
    {
        return viewBook.getTranslator();
    }
    
    /**
    * method to get page
    * @return reatePages(viewBook.getPage()) String
    */
    public String getPage()
    {
        return createPages(viewBook.getPage());
    }
    
    /**
    * method to get cover type
    * @return viewBook.getBookCover() String
    */
    public String getCoverType()
    {
        return viewBook.getBookCover();
    }
    
    /**
    * method to get publisher
    * @return viewBook.getPublisher()String
    */
    public String getPublisher()
    {
        return viewBook.getPublisher();
    }
    
    /**
    * method to get publisher date
    * @return createDate(viewBook.getPublisherDate()) String
    */
    public String getPublisherDate()
    {
        return createDate(viewBook.getPublisherDate());
    }
    
    /**
    * method to get price
    * @return createPrice(viewBook.getPrice()) String
    */
    public String getPrice()
    {
        return createPrice(viewBook.getPrice());
    }
    
    /**
    * method to get content page
    * @return viewBook.getContentPage() String
    */
    public String getContentPage()
    {
        return viewBook.getContentPage();
    }
    
    /**
    * method to get book information
    * @return StringReplacer(sentenceToParagraph(viewBook.getBookInfo()) String
    */
    public String getBookInformation()
    {
        return  StringReplacer(sentenceToParagraph(viewBook.getBookInfo()));
    }
    
    /**
    * method to get author information
    * @return StringReplacer(sentenceToParagraph(viewBook.getAboutAuthor())) String
    */
    public String getAuthorInfo()
    {
        return StringReplacer(sentenceToParagraph(viewBook.getAboutAuthor()));
    }
}
