package bskyblock.addon.simpleschems;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import us.tastybento.bskyblock.api.commands.CompositeCommand;
import us.tastybento.bskyblock.api.user.User;

public class Command extends CompositeCommand {
    public static final String COMMAND = "schem";
    private SimpleSchems addon;
    private Map<UUID, Clipboard> clipboards = new HashMap<>();

    public Command(SimpleSchems addon) {
        super(COMMAND);
        this.addon = addon;
        // Set up commands
    }

    public void setup() {
        // TODO Auto-generated method stub

    }

    public boolean execute(User user, List<String> args) {
        user.sendRawMessage("Schem!");
        if (args.isEmpty()) {
            return false;
        }
        Clipboard cb = clipboards.getOrDefault(user.getUniqueId(), new Clipboard(addon));

        if (args.get(0).equalsIgnoreCase("paste")) {
            user.sendRawMessage("paste");
            File file = new File(addon.getDataFolder(), "block.yml");            
            cb.load(file);            
            cb.paste(user.getLocation());
        }

        if (args.get(0).equalsIgnoreCase("copy")) {
            user.sendRawMessage("copy");
            if (cb.copy(user.getLocation())) {
                File file = new File(addon.getDataFolder(), "block.yml");
                user.sendRawMessage("File being written to " + file.getAbsolutePath());
                cb.save(file);
                return true;
            } 
            user.sendRawMessage("Failure - Did you specify both pos1 and pos2?");
            return false;
        }

        if (args.get(0).equalsIgnoreCase("pos1")) {
            cb.setPos1(user.getLocation());
            user.sendRawMessage("Set pos1 to " + user.getLocation().toVector().toString());
            clipboards.put(user.getUniqueId(), cb);
            return true;
        }

        if (args.get(0).equalsIgnoreCase("pos2")) {
            cb.setPos2(user.getLocation());
            user.sendRawMessage("Set pos2 to " + user.getLocation().toVector().toString());
            clipboards.put(user.getUniqueId(), cb);
            return true;
        }

        return false;
    }
    
}
