package menufact.observer;

import menufact.plats.PlatChoisi;

public interface EventListener {
    /**
     * @param plat
     */
    void update(PlatChoisi plat);
}
