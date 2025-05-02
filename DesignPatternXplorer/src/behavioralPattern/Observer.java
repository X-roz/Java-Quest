package behavioralPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Observer {

    public static void main(String[] args) {
        Editor editor = new Editor();

        EmailNotification emailNotification = new EmailNotification();
        MobileNotification mobileNotification = new MobileNotification();

        editor.events.subscribe("open", emailNotification);
        editor.events.subscribe("save", mobileNotification);

        editor.openFile("test.txt");
        editor.saveFile();

        System.out.println();

        editor.events.unsubscribe("open", emailNotification);
        editor.events.subscribe("open", mobileNotification);

        editor.openFile("test1.txt");
        editor.saveFile();
    }

}

/// Observer

/// Used when user needs to wait/observer for something. we can add a registry layer and notify user when an event or operation occur/done.
/// Define a subscription mechanism
/// Notify multiple objects simultaneously
/// One-to-Many relationship

interface EventListener {
    void notify(String eventType, String filename);
}

// Registry -> Maintain the list of parties who wants to notify an event
class EventManager {
    Map<String, ArrayList<EventListener>> listeners = new HashMap<>();

    public EventManager(String ... operations) {
        Arrays.stream(operations).forEach(op->listeners.put(op, new ArrayList<>()));
    }

    public void subscribe(String event, EventListener listener){
        ArrayList<EventListener> eventListenersList = listeners.get(event);
        if (!eventListenersList.contains(listener)){
            eventListenersList.add(listener);
        }
    }

    public void unsubscribe(String event, EventListener listener) {
        ArrayList<EventListener> eventListenersList = listeners.get(event);
        eventListenersList.remove(listener);
    }

    public void notify(String event, String file) {
        ArrayList<EventListener> eventListenersList = listeners.get(event);
        eventListenersList.forEach(l -> l.notify(event, file));
    }

}


// Available events to perform notifications
class Editor {
    public EventManager events = new EventManager("open", "save");
    String  file = "";

    public void openFile(String file) {
        this.file = file;
        events.notify("open", file);
    }

    public void saveFile() {
        events.notify("save", file);
    }

}

// Ways to notify users
class EmailNotification implements EventListener{

    @Override
    public void notify(String eventType, String filename) {
        System.out.println("Email Notification : "+ eventType + " performed on file " + filename);
    }
}

class MobileNotification implements EventListener{

    @Override
    public void notify(String eventType, String filename) {
        System.out.println("Mobile Notification : "+ eventType + " performed on file " + filename);
    }
}