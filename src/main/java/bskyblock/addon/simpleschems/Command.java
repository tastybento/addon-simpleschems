package bskyblock.addon.simpleschems;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.block.BlockFace;

import us.tastybento.bskyblock.api.commands.CompositeCommand;
import us.tastybento.bskyblock.api.user.User;

public class Command extends CompositeCommand {
    public static final String COMMAND = "schem";
    private SimpleSchems addon;

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

        if (args.get(0).equalsIgnoreCase("pos1")) {
            user.sendRawMessage("pos1");
            Clipboard cb = new Clipboard(user.getLocation(), user.getLocation());
            File file = new File(addon.getDataFolder(), "block.yml");
            user.sendRawMessage("File being written to " + file.getAbsolutePath());
            cb.getBlocks().forEach(b -> {
                user.sendRawMessage("Block b = " + b.getBlockConfig().getString("type"));
                try {
                    b.getBlockConfig().save(file);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        }
        return false;
    }


}
