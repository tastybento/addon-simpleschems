package bskyblock.addon.simpleschems;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.material.Attachable;
import org.bukkit.material.Colorable;
import org.bukkit.material.Directional;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Openable;
import org.bukkit.material.Redstone;


public class BSBBlock {
    private YamlConfiguration blockConfig = new YamlConfiguration();

    public BSBBlock(Block block, Location origin) {
        blockConfig.set("type", block.getType().toString());
        // TODO set to int
        blockConfig.set("pos", block.getLocation().toVector().subtract(origin.toVector()).toString());
        BlockState bs = block.getState();
        
        // Material Data
        MaterialData md = bs.getData();
        if (md instanceof Openable) {
            Bukkit.getLogger().info("Openable");
            Openable open = (Openable)md;
            blockConfig.set("open", open.isOpen()); 
        }
        if (md instanceof Directional) {
            Bukkit.getLogger().info("Directional");
            Directional facing = (Directional)md;
            blockConfig.set("facing", facing.getFacing().name()); 
        }
        if (md instanceof Attachable) {
            Bukkit.getLogger().info("Attachable");
            Attachable facing = (Attachable)md;
            blockConfig.set("facing", facing.getFacing().name());
            blockConfig.set("attached-face", facing.getAttachedFace().name());
        }
        if (md instanceof Colorable) {
            Bukkit.getLogger().info("Colorable");
            Colorable x = (Colorable)md;
            blockConfig.set("facing", x.getColor().name());
        }
        if (md instanceof Redstone) {
            Bukkit.getLogger().info("Redstone");
            Redstone x = (Redstone)md;
            blockConfig.set("powered", x.isPowered());
        }
        
        // Block data
        if (bs instanceof Sign) {
            Bukkit.getLogger().info("Sign");
            Sign x = (Sign)bs;
            blockConfig.set("lines", Arrays.asList(x.getLines()));
        }
        if (bs instanceof InventoryHolder) {
            Bukkit.getLogger().info("Inventory holder");
            InventoryHolder ih = (InventoryHolder)bs;
            blockConfig.set("inventory", ih.getInventory().getContents());
        }
        
    }

    /**
     * @return the blockConfig
     */
    public YamlConfiguration getBlockConfig() {
        return blockConfig;
    }

    /**
     * @param blockConfig the blockConfig to set
     */
    public void setBlockConfig(YamlConfiguration blockConfig) {
        this.blockConfig = blockConfig;
    }
    
    
}
