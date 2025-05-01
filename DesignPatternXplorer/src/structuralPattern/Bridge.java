package structuralPattern;

public class Bridge {

    public static void main(String[] args){

        PhoneOs android = new Android();
        Applications instagram = new Instagram(android);
        instagram.run();

        PhoneOs ios = new IOS();
        Applications facebook = new Facebook(ios);
        facebook.run();

    }
}

/// Bridge Use case : When we need multiple Orthogonal traits (Statically independent),
/// we need to build multi-level of inheritance and its complex to build the system.
/// Using bridge we can separate the traits and bridge/connects them together

/// Example:
/// Android phone runs application in different way when we compare it with IOS.
/// Phone OS and Apps are statically independent traits. we can design code using Bridge pattern.

interface PhoneOs {

    // Mobile OS Operations to run apps
    void displayScreen(String data);
    void upload(String data);
    void download(String data);

}

class Android implements PhoneOs {

    @Override
    public void displayScreen(String data) {
        System.out.println("Android OS : Display data on screen " + data);
    }

    @Override
    public void upload(String data) {
        System.out.println("Android OS : Upload " + data);
    }

    @Override
    public void download(String data) {
        System.out.println("Android OS : Downloading " + data);
    }
}

class IOS implements PhoneOs {

    @Override
    public void displayScreen(String data) {
        System.out.println("IOS : Display data on screen " + data);
    }

    @Override
    public void upload(String data) {
        System.out.println("IOS : Upload " + data);
    }

    @Override
    public void download(String data) {
        System.out.println("IOS : Downloading " + data);
    }
}

interface Applications {

    // Running Applications on Phone OS
    void run();
}

class Instagram implements Applications {

    private final PhoneOs phoneOs;

    Instagram(PhoneOs phoneOs){
        this.phoneOs = phoneOs;
    }

    @Override
    public void run() {
        phoneOs.displayScreen("Instagram Logo");
        phoneOs.download("pics/user");
        phoneOs.upload("story/user");
    }
}

class Facebook implements Applications {

    private final PhoneOs phoneOs;

    Facebook(PhoneOs phoneOs){
        this.phoneOs = phoneOs;
    }

    @Override
    public void run() {
        phoneOs.displayScreen("Facebook Logo");
        phoneOs.download("image/user");
        phoneOs.upload("blog/user");
    }
}