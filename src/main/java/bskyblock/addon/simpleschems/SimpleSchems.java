package bskyblock.addon.simpleschems;

import us.tastybento.bskyblock.api.addons.Addon;

public class SimpleSchems extends Addon {

    public void onEnable() {
        new Command(this);
        this.saveDefaultConfig();
        
    }

    public void onDisable() {
        // TODO Auto-generated method stub
        
    }

}
