package structuralPattern;

public class Proxy {

    public  static void main(String[] args){

        Image image = new ProxyImage("sample.jpg");

        // While this method invoke the proxy image class doesn't have the real image data so it will instantiate the real image in proxy class.
        image.display();
        System.out.println();

        // Now Proxy does have the real data already instantiated so we are reducing the call to datasource
        image.display();
    }
}

// An interface to access the image
interface Image {
    void display();
}

// Original Image
class RealImage implements Image{

    private final String filename;

    RealImage(String filename){
        System.out.println("Real Image : loading file " + filename);
        this.filename=filename;
    }

    @Override
    public void display() {
        System.out.println("Real Image : Displaying Image " + filename);
    }
}

class ProxyImage implements Image{

    private final String filename;

    // Temporarily holds the image data
    private RealImage realImage;

    ProxyImage(String filename){
        this.filename=filename;
    }

    @Override
    public void display() {
        System.out.println("Proxy Image : Displaying Image " + filename);
        if(realImage == null){
          realImage = new RealImage(filename);
        }
        realImage.display();
        System.out.println("Proxy Image: logging image "+ realImage);
    }
}

///  Proxy - an interface that mimic the original datasource.
// for instance, we have multiple client accessing the database. For each call we need to wait certain time to retrieve the data.
// So If we add a caching/interface layer that stores data in memory temporarily and processes multiple client requests efficiently.


