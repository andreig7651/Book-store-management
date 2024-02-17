import java.util.ArrayList;

public class Administration  {

    private ArrayList<Book> books=new ArrayList<Book>();
    public void setBooks(ArrayList<Book> books){
        this.books=books;
    }
    public ArrayList<Book>getBooks(){
        return this.books;
    }

    private ArrayList<Language> languages=new ArrayList<Language>();
    public void setLanguages(ArrayList<Language> languages) {
        this.languages=languages;
    }
    public ArrayList<Language>getLanguages(){
        return this.languages;
    }

    private ArrayList<Author> authors=new ArrayList<Author>();
    public void setAuthors(ArrayList<Author> authors){
        this.authors=authors;
    }
    public ArrayList<Author>getAuthors(){
        return this.authors;
    }

    private ArrayList<EditorialGroup> groups=new ArrayList<EditorialGroup>();
    public void setGroups(ArrayList<EditorialGroup> groups){
        this.groups=groups;
    }
    public ArrayList<EditorialGroup>getGroups(){
        return this.groups;
    }

    private ArrayList<PublishingBrand> brands=new ArrayList<PublishingBrand>();
    public void setBrands(ArrayList<PublishingBrand> brands){
        this.brands=brands;
    }
    public ArrayList<PublishingBrand>getBrands(){
        return this.brands;
    }

    private ArrayList<PublishingRetailer> retailers=new ArrayList<PublishingRetailer>();
    public void setRetailers(ArrayList<PublishingRetailer> retailers){
        this.retailers=retailers;
    }
    public ArrayList<PublishingRetailer>getRetailers(){
        return this.retailers;
    }

    private ArrayList<Countries> countries=new ArrayList<Countries>();
    public void setCountries(ArrayList<Countries> countries){
        this.countries=countries;
    }
    public ArrayList<Countries>getCountries(){
        return this.countries;
    }

    ArrayList<Book> addBook(ArrayList<Book> booklist,Book mybook){
        for(Book book :booklist)
            if(mybook.ID==book.ID)
                return booklist;
        booklist.add(mybook);
        return booklist;
    }

    ArrayList<Language> addLanguage(ArrayList<Language> languagelist,Language mylanguage){
        for(Language language :languagelist)
            if(mylanguage.code==language.code)
                return languagelist;
        languagelist.add(mylanguage);
        return languagelist;
    }

    ArrayList<Countries> addCountry(ArrayList<Countries> countrylist,Countries mycountry){
        for(Countries country :countries)
            if(mycountry.countryCode==country.countryCode)
                return countrylist;
        countrylist.add(mycountry);
        return countrylist;
    }

    ArrayList<Book> getBooksForPublishingRetailerID(int publishingRetailerID){
        ArrayList<Book> booklist=new ArrayList<Book>();
        for(PublishingRetailer retailer:retailers)
            if(retailer.ID==publishingRetailerID)
                for(IPublishingArtifact artifact:retailer.publishingArtifacts){
                    if(artifact instanceof Book)
                        addBook(booklist, (Book) artifact);
                    if(artifact instanceof EditorialGroup){
                        for(Book mybook: ((EditorialGroup) artifact).books)
                            addBook(booklist,mybook);
                    }
                    if(artifact instanceof PublishingBrand){
                        for(Book mybook: ((PublishingBrand) artifact).books)
                            addBook(booklist,mybook);
                    }
                }
        return booklist;

    }

    ArrayList<Language> getLanguagesForPublishingRetailerID(int publishingReatilerID){
        ArrayList<Language>retailerlanguages=new ArrayList<Language>();
        for(PublishingRetailer retailer:retailers)
            if (retailer.ID == publishingReatilerID){
                for(IPublishingArtifact artifact:retailer.publishingArtifacts) {
                    if (artifact instanceof Book) {
                        for (Language language : languages)
                            if (((Book) artifact).languageID == language.ID)
                                addLanguage(retailerlanguages, language);
                    }
                    if(artifact instanceof EditorialGroup){
                        for(Book mybook: ((EditorialGroup) artifact).books)
                            for (Language language : languages)
                                if (mybook.languageID == language.ID)
                                    addLanguage(retailerlanguages, language);
                    }
                    if(artifact instanceof PublishingBrand){
                        for(Book mybook: ((PublishingBrand) artifact).books)
                            for (Language language : languages)
                                if (mybook.languageID == language.ID)
                                    addLanguage(retailerlanguages, language);
                    }

                }
            }
    return retailerlanguages;
}

    ArrayList<Countries> getCountriesForBookID(int bookID){
        ArrayList<Countries>countrieslist=new ArrayList<Countries>();
        for(PublishingRetailer retailer:retailers)
                for(IPublishingArtifact artifact:retailer.publishingArtifacts){
                    if(artifact instanceof Book){
                       if(((Book) artifact).ID== bookID)
                           for(Countries country: retailer.countries)
                               addCountry(countrieslist,country);
                    }
                    if(artifact instanceof EditorialGroup){
                        for(Book book:((EditorialGroup) artifact).books)
                            if(book.ID==bookID)
                                for(Countries country: retailer.countries)
                                    addCountry(countrieslist,country);
                    }
                    if(artifact instanceof PublishingBrand){
                        for(Book book:((EditorialGroup) artifact).books)
                            if(book.ID==bookID)
                                for(Countries country: retailer.countries)
                                    addCountry(countrieslist,country);
                    }
                }
        return countrieslist;
    }

    ArrayList<Book> getCommonBooksForRetailerIDs(int retailerID1, int retailerID2){
        ArrayList<Book> commonbooks=new ArrayList<Book>();
        ArrayList<Book> list1=getBooksForPublishingRetailerID(retailerID1);
        ArrayList<Book> list2=getBooksForPublishingRetailerID(retailerID2);
        for(Book book1 :list1){
            for(Book book2:list2) {
                if (book1.ID == book2.ID)
                    commonbooks.add(book1);
            }
        }

        return commonbooks;
    }

    ArrayList<Book> getAllBooksForRetailerIDs(int retailerID1, int retailerID2){
        ArrayList<Book> unionbooks;
        ArrayList<Book> list1=getBooksForPublishingRetailerID(retailerID1);
        ArrayList<Book> list2=getBooksForPublishingRetailerID(retailerID2);
        unionbooks=list1;
        for(Book book2 :list2){
            int ok=1;
            for(Book book:unionbooks) {
                if (book2.ID == book.ID)
                    ok = 0;
            }
            if (ok==1)
                unionbooks.add(book2);
        }

        return unionbooks;
    }
}
