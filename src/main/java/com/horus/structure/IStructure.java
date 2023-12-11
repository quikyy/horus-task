package com.horus.structure;

import com.horus.block.Block;

import java.util.List;
import java.util.Optional;

public interface IStructure {

    Optional<Block> findBlockByColor(String color);

    List<Block> findBlocksByMaterial(String material);

    int count();

}
