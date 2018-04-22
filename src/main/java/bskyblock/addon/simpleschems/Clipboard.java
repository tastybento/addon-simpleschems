package bskyblock.addon.simpleschems;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Location;

public class Clipboard {

    private Location pos1;
    private Location pos2;
    private Set<BSBBlock> blocks = new HashSet<>();
    /**
     * @param pos1
     * @param pos2
     */
    public Clipboard(Location pos1, Location pos2) {
        this.pos1 = pos1;
        this.pos2 = pos2;
        BSBBlock block = new BSBBlock(pos1.getBlock(), pos1);
        blocks.add(block);
    }
    /**
     * @return the blocks
     */
    public Set<BSBBlock> getBlocks() {
        return blocks;
    }
    /**
     * @param blocks the blocks to set
     */
    public void setBlocks(Set<BSBBlock> blocks) {
        this.blocks = blocks;
    }
    
    
}
