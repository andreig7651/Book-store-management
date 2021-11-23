import java.util.Calendar;
import java.awt.*;
import java.util.ArrayList;

public class Book implements IPublishingArtifact {
    int ID;
    String name;
    String subtitle;
    public String ISBN;
    int pageCount;
    public ArrayList<String> keywords;
    int languageID;
    Calendar createdOn;
    public ArrayList<Author> authors;

    public Book(){
        authors=new ArrayList<Author>();
        keywords=new ArrayList<String>();
    }

    public void Publish() {
        System.out.println("<xml>");
        System.out.println("\t"+"<title>"+name+"</title>");
        if(subtitle!=null)
            System.out.println("\t"+"<subtitle>"+subtitle+"</subtitle>");
        System.out.println("\t"+"<isbn>"+ISBN+"</isbn>");
        System.out.println("\t"+"<pageCount>"+pageCount+"</pageCount>");
        for(String keyword: keywords)
            System.out.println("\t"+"<keywords>"+keyword+"</keywords>");
        System.out.println("\t"+"<languageID>"+languageID+"</languageID>");
        System.out.print("\t"+"<createdOn>");
        System.out.print(createdOn.get(Calendar.DAY_OF_MONTH)+"."+createdOn.get(Calendar.MONTH)+"."+createdOn.get(Calendar.YEAR));
        System.out.print(" "+createdOn.get(Calendar.HOUR_OF_DAY)+":"+createdOn.get(Calendar.MINUTE)+":"+createdOn.get(Calendar.SECOND));
        System.out.println("</createdOn>");
        System.out.print("\t"+"<authors>");
        for(Author author:authors)
            System.out.print(author.firstName+" "+author.lastName);
        System.out.println("</authors>");
        System.out.println("</xml>");

    }

    @Override
    public String publish() {
        return null;
    }
}
