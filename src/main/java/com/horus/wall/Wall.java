package com.horus.wall;

import com.horus.block.Block;
import com.horus.structure.IStructure;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
public class Wall implements IStructure {

    private final List<Block> blocks = new ArrayList<>();

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(b -> b.getColor().equalsIgnoreCase(color))
                .findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream().filter(b -> b.getMaterial().equalsIgnoreCase(material)).toList();
    }

    @Override
    public int count() {
        return this.blocks.size();
    }

    public void addBlock(Block block) {
        this.blocks.add(block);
    }

}
