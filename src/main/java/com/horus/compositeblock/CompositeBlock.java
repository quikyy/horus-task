package com.horus.compositeblock;

import com.horus.block.Block;
import lombok.AllArgsConstructor;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class CompositeBlock implements ICompositeBlock {

    private List<Block> blocks;

    @Override
    public List<Block> getBlocks() {
        return this.blocks;
    }

    @Override
    public String getColor() {
        Set<String> colorsSet = new HashSet<>();
        for (Block block : this.blocks) {
            colorsSet.add(block.getColor());
        }
        return this.joinStringSetByComma(colorsSet);
    }

    @Override
    public String getMaterial() {
        Set<String> materialsSet = new HashSet<>();
        for (Block block : this.blocks) {
            materialsSet.add(block.getColor());
        }
        return this.joinStringSetByComma(materialsSet);
    }

    private String joinStringSetByComma(Set<String> stringSet) {
        return String.join(", ", stringSet);
    }
}
