package com.horus.compositeblock;

import com.horus.block.Block;
import com.horus.block.IBlock;

import java.util.List;

public interface ICompositeBlock extends IBlock {

    List<Block> getBlocks();

}
