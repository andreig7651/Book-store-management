import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.*;

public class tema1 {

    public static void main(String[] args){

        Administration administrator=new Administration();
        ArrayList<Book> books = administrator.getBooks();
        ArrayList<Language> languages = administrator.getLanguages();
        ArrayList<Author> authors = administrator.getAuthors();
        ArrayList<EditorialGroup> groups = administrator.getGroups();
        ArrayList<PublishingBrand> brands = administrator.getBrands();
        ArrayList<PublishingRetailer> retailers = administrator.getRetailers();
        ArrayList<Countries> countries = administrator.getCountries();

        try {
            File myfile = new File("D:\\Anul 2\\Programare orientata pe obiecte\\Tema 1\\src\\init\\init\\books.in");
            Scanner myReader = new Scanner(myfile);
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                Book mybook = new Book();

                int ok=0;
                for (String word: line.split("###")) {
                    switch(ok) {
                        case 0:
                            mybook.ID = Integer.parseInt(word);
                            ok++;
                            break;

                        case 1:
                            mybook.name = word;
                            ok++;
                            break;

                        case 2:
                            mybook.subtitle = word;
                            ok++;
                            break;

                        case 3:
                            mybook.ISBN = word;
                            ok++;
                            break;

                        case 4:
                            mybook.pageCount = Integer.parseInt(word);
                            ok++;
                            break;

                        case 5:
                            for (String keyword: word.split(";")){
                                mybook.keywords.add(keyword);
                            }
                            ok++;
                            break;

                        case 6:
                            mybook.languageID=Integer.parseInt(word);
                            ok++;
                            break;

                        case 7:

                            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
                            Date date = sdf.parse(word);
                            mybook.createdOn = Calendar.getInstance();
                            mybook.createdOn.setTime(date);
                            ok++;
                            break;
                    }

                }
                books.add(mybook);
                administrator.setBooks(books);
            }
            myReader.close();
        } catch (FileNotFoundException | ParseException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myfile = new File("D:\\Anul 2\\Programare orientata pe obiecte\\Tema 1\\src\\init\\init\\languages.in");
            Scanner myReader = new Scanner(myfile);
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                Language mylanguage = new Language();

                int ok=0;
                for (String word: line.split("###")) {
                    switch(ok) {
                        case 0:

                            mylanguage.ID = Integer.parseInt(word);
                            ok++;
                            break;

                        case 1:

                            mylanguage.code = word;
                            ok++;
                            break;

                        case 2:
                            mylanguage.name = word;
                            ok++;
                            break;
                    }

                }
                languages.add(mylanguage);
                administrator.setLanguages(languages);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myfile = new File("D:\\Anul 2\\Programare orientata pe obiecte\\Tema 1\\src\\init\\init\\authors.in");
            Scanner myReader = new Scanner(myfile);
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                Author myauthor = new Author();

                int ok=0;
                for (String word: line.split("###")) {
                    switch(ok) {
                        case 0:
                            myauthor.ID = Integer.parseInt(word);
                            ok++;
                            break;

                        case 1:
                            myauthor.firstName = word;
                            ok++;
                            break;

                        case 2:
                            myauthor.lastName = word;
                            ok++;
                            break;
                    }

                }
                authors.add(myauthor);
                administrator.setAuthors(authors);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myfile = new File("D:\\Anul 2\\Programare orientata pe obiecte\\Tema 1\\src\\init\\init\\books-authors.in");
            Scanner myReader = new Scanner(myfile);
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                int bookID=0,authorID=0,ok=0;
                for (String word: line.split("###")) {
                    switch(ok) {
                        case 0:
                            bookID=Integer.parseInt(word);
                            ok++;
                            break;

                        case 1:
                            authorID=Integer.parseInt(word);
                            ok++;
                            break;
                    }

                }

                for(Book book:books) {
                    if (book.ID == bookID)
                        for (Author author : authors)
                            if (author.ID == authorID) {
                                book.authors.add(author);
                            }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myfile = new File("D:\\Anul 2\\Programare orientata pe obiecte\\Tema 1\\src\\init\\init\\editorial-groups.in");
            Scanner myReader = new Scanner(myfile);
            myReader.nextLine();

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                int ok=0;
                EditorialGroup mygroup=new EditorialGroup();

                for (String word: line.split("###")) {
                    switch(ok) {
                        case 0:
                            mygroup.ID=Integer.parseInt(word);
                            ok++;
                            break;

                        case 1:
                            mygroup.name=word;
                            ok++;
                            break;
                    }

                }
                groups.add(mygroup);
                administrator.setGroups(groups);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myfile = new File("D:\\Anul 2\\Programare orientata pe obiecte\\Tema 1\\src\\init\\init\\publishing-brands.in");
            Scanner myReader = new Scanner(myfile);
            myReader.nextLine();

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                int ok=0;
                PublishingBrand mybrand=new PublishingBrand();

                for (String word: line.split("###")) {
                    switch(ok) {
                        case 0:
                            mybrand.ID=Integer.parseInt(word);
                            ok++;
                            break;

                        case 1:
                            mybrand.name=word;
                            ok++;
                            break;
                    }

                }
                brands.add(mybrand);
                administrator.setBrands(brands);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myfile = new File("D:\\Anul 2\\Programare orientata pe obiecte\\Tema 1\\src\\init\\init\\editorial-groups-books.in");
            Scanner myReader = new Scanner(myfile);
            myReader.nextLine();

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                int ok=0,groupID=0,authorID=0;

                for (String word: line.split("###")) {
                    switch(ok) {
                        case 0:
                            groupID=Integer.parseInt(word);
                            ok++;
                            break;

                        case 1:
                            authorID=Integer.parseInt(word);
                            ok++;
                            break;
                    }

                }

                for(EditorialGroup group: groups) {
                    if (groupID == group.ID)
                        for (Book book : books)
                            for (Author author : book.authors)
                                if (authorID == author.ID)
                                    group.books.add(book);
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myfile = new File("D:\\Anul 2\\Programare orientata pe obiecte\\Tema 1\\src\\init\\init\\publishing-brands-books.in");
            Scanner myReader = new Scanner(myfile);
            myReader.nextLine();

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                int ok=0,brandID=0,authorID=0;

                for (String word: line.split("###")) {
                    switch(ok) {
                        case 0:
                            brandID=Integer.parseInt(word);
                            ok++;
                            break;

                        case 1:
                            authorID=Integer.parseInt(word);
                            ok++;
                            break;
                    }

                }

                for(PublishingBrand brand: brands) {
                    if (brandID == brand.ID)
                        for (Book book : books)
                            for (Author author : book.authors)
                                if (authorID == author.ID) {
                                    brand.books.add(book);
                                }
                }

            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myfile = new File("D:\\Anul 2\\Programare orientata pe obiecte\\Tema 1\\src\\init\\init\\publishing-retailers.in");
            Scanner myReader = new Scanner(myfile);
            myReader.nextLine();

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                int ok=0;
                PublishingRetailer myretailer=new PublishingRetailer();
                for (String word: line.split("###")) {
                    switch(ok) {
                        case 0:
                            myretailer.ID=Integer.parseInt(word);
                            ok++;
                            break;

                        case 1:
                            myretailer.name=word;
                            ok++;
                            break;
                    }

                }
                retailers.add(myretailer);
                administrator.setRetailers(retailers);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myfile = new File("D:\\Anul 2\\Programare orientata pe obiecte\\Tema 1\\src\\init\\init\\countries.in");
            Scanner myReader = new Scanner(myfile);
            myReader.nextLine();

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                int ok=0;
                Countries mycountry=new Countries();
                for (String word: line.split("###")) {
                    switch(ok) {
                        case 0:
                            mycountry.ID=Integer.parseInt(word);
                            ok++;
                            break;

                        case 1:
                            mycountry.countryCode=word;
                            ok++;
                            break;
                    }

                }
                countries.add(mycountry);
                administrator.setCountries(countries);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myfile = new File("D:\\Anul 2\\Programare orientata pe obiecte\\Tema 1\\src\\init\\init\\publishing-retailers-countries.in");
            Scanner myReader = new Scanner(myfile);
            myReader.nextLine();

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                int ok=0,retailerID=0,countryID=0;

                for (String word: line.split("###")) {
                    switch(ok) {
                        case 0:
                            retailerID=Integer.parseInt(word);
                            ok++;
                            break;

                        case 1:
                            countryID=Integer.parseInt(word);
                            ok++;
                            break;
                    }

                }

                for(PublishingRetailer retailer: retailers) {
                    if (retailerID == retailer.ID)
                        for(Countries country: countries)
                            if(countryID == country.ID)
                                retailer.countries.add(country);
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myfile = new File("D:\\Anul 2\\Programare orientata pe obiecte\\Tema 1\\src\\init\\init\\publishing-retailers-books.in");
            Scanner myReader = new Scanner(myfile);
            myReader.nextLine();

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                int ok=0,retailerID=0,bookID=0;

                for (String word: line.split("###")) {
                    switch(ok) {
                        case 0:
                            retailerID=Integer.parseInt(word);
                            ok++;
                            break;

                        case 1:
                            bookID=Integer.parseInt(word);
                            ok++;
                            break;
                    }

                }

                for(PublishingRetailer retailer: retailers) {
                    if (retailerID == retailer.ID)
                        for(Book book: books)
                            if(bookID == book.ID)
                                retailer.publishingArtifacts.add(book);
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myfile = new File("D:\\Anul 2\\Programare orientata pe obiecte\\Tema 1\\src\\init\\init\\publishing-retailers-editorial-groups.in");
            Scanner myReader = new Scanner(myfile);
            myReader.nextLine();

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                int ok=0,retailerID=0,groupID=0;

                for (String word: line.split("###")) {
                    switch(ok) {
                        case 0:
                            retailerID=Integer.parseInt(word);
                            ok++;
                            break;

                        case 1:
                            groupID=Integer.parseInt(word);
                            ok++;
                            break;
                    }

                }

                for(PublishingRetailer retailer: retailers) {
                    if (retailerID == retailer.ID)
                        for (EditorialGroup group : groups)
                            if (groupID == group.ID) {
                                retailer.publishingArtifacts.add(group);
                            }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myfile = new File("D:\\Anul 2\\Programare orientata pe obiecte\\Tema 1\\src\\init\\init\\publishing-retailers-publishing-brands.in");
            Scanner myReader = new Scanner(myfile);
            myReader.nextLine();

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                int ok=0,retailerID=0,brandID=0;

                for (String word: line.split("###")) {
                    switch(ok) {
                        case 0:
                            retailerID=Integer.parseInt(word);
                            ok++;
                            break;

                        case 1:
                            brandID=Integer.parseInt(word);
                            ok++;
                            break;
                    }

                }

                for(PublishingRetailer retailer: retailers) {
                    if (retailerID == retailer.ID)
                        for(PublishingBrand brand: brands)
                            if(brandID == brand.ID)
                                retailer.publishingArtifacts.add(brand);
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}

