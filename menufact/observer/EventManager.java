package menufact.observer;

import menufact.state.PlatChoisi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EventManager {
    private Map<String, ArrayList<EventListener>> listeners = new HashMap<>();

    /**
     * @param events est la liste des events a ajouter au eventmanager
     */
    public EventManager(String...events){
        for(String event : events){
            listeners.put(event, new ArrayList<>());
        }
    }

    /**
     * @param event est l'event auquel on doit subscribe
     * @param listener est l'objet qui est notifie lorsque l'event est appele
     */
    public void subscribe(String event, EventListener listener){
        listeners.get(event).add(listener);
    }

    /**
     * @param event est l'event auquel on veut unsubscribe
     * @param listener est l'objet qu'on veut retirer de la notification
     */
    public void unsubscribe(String event, EventListener listener){
        listeners.get(event).remove(listener);
    }

    /**
     * @param event est l'event qu'on veut notifier aux listeners
     * @param plat est le plat qu'on veut envoyer aux listeners
     */
    public void notify(String event, PlatChoisi plat){
        ArrayList<EventListener> subscribers = listeners.get(event);
        for(EventListener subscriber : subscribers){
            subscriber.update(plat);
        }
    }
}
