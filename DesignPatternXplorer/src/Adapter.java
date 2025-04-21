import java.util.ArrayList;
import java.util.List;

public class Adapter {

    public static void main(String[] args){

        // Data from 3rd party
        List<Resources> resourcesList = List.of(
                new Resources("github.com/X-roz", "Java-Quest","Vignesh"),
                new Resources("github.com/X-roz", "GO-Quest","Vignesh"),
                new Resources("github.com/X-roz", "AI-Quest","Vignesh")
        );

        // Convert the 3rd party resource list to our existing usage
        ResourceAdapter resourceAdapter = new ResourceAdapterImpl();
        resourceAdapter.convertResources(resourcesList).stream().map(DbResource::displayResources)
                .forEach(System.out::println);
    }
}

/// Adapter: we need to combine/map data from one object to another. we can use Adapter Method.

interface ResourceAdapter {
    List<DbResource> convertResources(List<Resources> resourcesList);
}

class ResourceAdapterImpl implements ResourceAdapter{

    @Override
    public List<DbResource> convertResources(List<Resources> resourcesList) {
        List<DbResource> dbResourceList = new ArrayList<>();
        resourcesList.forEach(r -> dbResourceList.add(new DbResource(r.url, r.repository, r.owner)));
        return dbResourceList;
    }
}


/// Legacy Code: No control over the code
class Resources {
    String url;
    String repository;
    String owner;

    Resources(String url, String repository, String owner){
        this.url = url;
        this.repository =repository;
        this.owner = owner;
    }
}

/// Our Existing Code
class DbResource {
    String urlName;
    String repository;
    String author;

    DbResource(String urlName, String repository, String author){
        this.urlName = urlName;
        this.repository =repository;
        this.author = author;
    }

    public String displayResources() {
        return "url : "+ urlName + " repository : "+ repository + " Author : " + author;
    }
}



