package menufact;

import menufact.exceptions.MenuException;
import menufact.plats.FactoryPlatAuMenu;
import menufact.plats.PlatAuMenu;

import java.util.ArrayList;

public class Menu {
    private static Menu menu;
    private String description;
    private int courant;
    private ArrayList<PlatAuMenu> plats = new ArrayList<PlatAuMenu>();

    private Menu() {
        courant = 0;
    }

    /**
     * @param p
     */
    public void ajoute (PlatAuMenu p) { plats.add(p); }

    /**
     * @param i
     * @throws MenuException
     */
    public void position(int i) throws MenuException
    {
        if (i >= plats.size())
            throw new MenuException("On depasse le nombre de plats du menu.");
        else
            courant = i;
    }

    public int getPosition() {
        return courant;
    }

    /**
     * @return
     */
    public PlatAuMenu platCourant()
    {
        return plats.get(courant);
    }

    /**
     * @param code
     * @return
     */
    public PlatAuMenu getPlatAuMenu(int code){
        for(PlatAuMenu plat : plats){
            if(plat.getCode() == code){
                return plat;
            }
        }
        FactoryPlatAuMenu factory = new FactoryPlatAuMenu();
        PlatAuMenu plat = factory.createPlat();
        plat.setDescription("Le plat n'est pas au menu");
        return plat;
    }

    public ArrayList<PlatAuMenu> getAllPlatAuMenu(){
        return this.plats;
    }

    /**
     * @throws MenuException
     */
    public void positionSuivante() throws MenuException
    {
        if (courant+1 >= plats.size())
            throw new MenuException("On depasse le nombre maximale de plats.");
        else
            courant++;
    }

    /**
     * @throws MenuException
     */
    public void positionPrecedente() throws MenuException
    {
        if (courant-1 < 0)
            throw new MenuException("On depasse le nombre minimale de plats");
        else
            courant--;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    /**
     * @return
     */
    public static Menu getMenu() {
        return menu = (menu == null) ? new Menu() : menu;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "menufact.Menu : {" +
                "description : '" + description + '\'' +
                ", courant : '" + courant + '\'' +
                ", plats : " + "\n" + plats + '}';
    }
}
