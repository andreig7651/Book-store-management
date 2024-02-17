import java.util.ArrayList;
import java.util.Calendar;

public class EditorialGroup implements IPublishingArtifact {
    int ID;
    String name;
    public ArrayList<Book> books;

    public EditorialGroup(){
        books=new ArrayList<Book>();
    }

    public void Publish() {
        System.out.println("<xml>");
        System.out.println("\t"+"<editorialGroup>");
        System.out.println("\t"+"\t"+"<ID>"+ID+"</ID>");
        System.out.println("\t"+"\t"+"<Name>"+name+"</Name>");
        System.out.println("\t"+"</editorialGroup>");
        System.out.println("\t"+"<books>");
        for(Book mybook: books){
            System.out.println("\t"+"\t"+"<book>");
                System.out.println("\t"+"\t"+"\t"+"<title>"+name+"</title>");
                if(mybook.subtitle!=null)
                    System.out.println("\t"+"\t"+"\t"+"<subtitle>"+mybook.subtitle+"</subtitle>");
                System.out.println("\t"+"\t"+"\t"+"<isbn>"+mybook.ISBN+"</isbn>");
                System.out.println("\t"+"\t"+"\t"+"<pageCount>"+mybook.pageCount+"</pageCount>");
                for(String keyword: mybook.keywords)
                    System.out.println("\t"+"\t"+"\t"+"<keywords>"+keyword+"</keywords>");
                System.out.println("\t"+"\t"+"\t"+"<languageID>"+mybook.languageID+"</languageID>");
                System.out.print("\t"+"\t"+"\t"+"<createdOn>");
                System.out.print(mybook.createdOn.get(Calendar.DAY_OF_MONTH)+"."+mybook.createdOn.get(Calendar.MONTH)+"."+mybook.createdOn.get(Calendar.YEAR));
                System.out.print(" "+mybook.createdOn.get(Calendar.HOUR_OF_DAY)+":"+mybook.createdOn.get(Calendar.MINUTE)+":"+mybook.createdOn.get(Calendar.SECOND));
                System.out.println("</createdOn>");
                System.out.print("\t"+"\t"+"\t"+"<authors>");
                for(Author author:mybook.authors) {
                    System.out.print(author.firstName+" "+author.lastName);
                }
                System.out.println("</authors>");
            System.out.println("\t"+"\t"+"</book>");
        }
        System.out.println("\t"+"</books>");
        System.out.println("</xml>");

    }

    @Override
    public String publish() {
        return null;
    }
}
