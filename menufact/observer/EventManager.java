package menufact.observer;

import menufact.plats.PlatChoisi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EventManager {
    private Map<String, ArrayList<EventListener>> listeners = new HashMap<>();

    public EventManager(String...events){
        for(String event : events){
            listeners.put(event, new ArrayList<>());
        }
    }

    public void subscribe(String event, EventListener listener){ listeners.get(event).add(listener); }

    public void unsubscribe(String event, EventListener listener){
        listeners.get(event).remove(listener);
    }

    public void notify(String event, PlatChoisi plat){
        ArrayList<EventListener> subscribers = listeners.get(event);
        for(EventListener subscriber : subscribers){
            subscriber.update(plat);
        }
    }
}
