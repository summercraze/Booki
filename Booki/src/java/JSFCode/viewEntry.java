/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFCode;


import JavaCode.Book;
import static JavaCode.usefuleCode.*;
import static SQLCode.SQLConnector.getBookInfo;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.sql.SQLException;

/**
 *
 * @author Rong
 */
@Named(value="viewEntry")
@RequestScoped
public class viewEntry 
{
    private String title = " ";
    private Book viewBook;
    /**
     * Creates a new instance of viewEntry
     */
    public viewEntry()
    {
        
    }
    public void setTitle(String title) throws ClassNotFoundException, SQLException
    {
        this.title = title;
        viewBook = getBookInfo(title);
    }
    public String getTitle()
    {
        return title;
    }
    public String getSubtitle()
    {
        return viewBook.getSubtitle();
    }
    public String getISBN()
    {
        return viewBook.getIsbn();
    }
    public String getAuthors()
    {
        return createAuthor(viewBook.getAuthor1(),viewBook.getAuthor2(),viewBook.getAuthor3());
    }
    public String getTranslator()
    {
        return viewBook.getTranslator();
    }
    public String getPage()
    {
        return createPages(viewBook.getPage());
    }
    public String getCoverType()
    {
        return viewBook.getBookCover();
    }
    public String getPublisher()
    {
        return viewBook.getPublisher();
    }
    public String getPublisherDate()
    {
        return createDate(viewBook.getPublisherDate());
    }
    public String getPrice()
    {
        return createPrice(viewBook.getPrice());
    }
    public String getContentPage()
    {
        return editContentPage(viewBook.getContentPage());
    }
    public String getBookInformation()
    {
        return  StringReplacer(sentenceToParagraph(viewBook.getBookInfo()));
    }
     public String getAuthorInfo()
    {
        return StringReplacer(sentenceToParagraph(viewBook.getAboutAuthor()));
    }
}
