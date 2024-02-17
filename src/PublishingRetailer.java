import java.util.ArrayList;

public class PublishingRetailer {
    int ID;
    String name;
    public ArrayList<IPublishingArtifact> publishingArtifacts;
    public ArrayList<Countries> countries;
    public PublishingRetailer(){
        countries=new ArrayList<Countries>();
        publishingArtifacts=new ArrayList<IPublishingArtifact>();
    }
}
