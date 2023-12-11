package com.horus;

import com.horus.block.Block;
import com.horus.compositeblock.CompositeBlock;
import com.horus.wall.Wall;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Optional;

public class Main {

    private static final String blackColor = "black";
    private static final String redColor = "red";
    private static final String metalMaterial = "metal";
    private static final String brickMaterial = "brick";
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Block brickBlock = new Block(redColor, brickMaterial);
        Block sandBlock = new Block("yellow", "sand");
        Block greenBlock = new Block("green", "grass");
        List<Block> firstCompositeBlocks = List.of(brickBlock, sandBlock, greenBlock);
        CompositeBlock firstCompositeBlock = new CompositeBlock(firstCompositeBlocks);

        Wall firstWall = new Wall();
        firstWall.addBlock(brickBlock);
        firstWall.addBlock(sandBlock);
        firstWall.addBlock(greenBlock);

        findBlockByColorAngLog(firstWall, blackColor);
        findBlockByColorAngLog(firstWall, redColor);

        findBlocksByMaterialAndLog(firstWall, metalMaterial);
        findBlocksByMaterialAndLog(firstWall, brickMaterial);
    }


    private static void findBlockByColorAngLog(Wall wall, String targetColor) {
        Optional<Block> optionalBrickBlock = wall.findBlockByColor(targetColor);
        if (optionalBrickBlock.isEmpty()) {
            logger.warn(String.format("No %s color block found", targetColor));
            return;
        }
        logger.info(String.format("Found %s block, hashCode: %o", targetColor, optionalBrickBlock.get().hashCode()));
    }

    private static void findBlocksByMaterialAndLog(Wall wall, String material) {
        List<Block> targetBlocks = wall.findBlocksByMaterial(material);
        if (targetBlocks.isEmpty()) {
            logger.warn(String.format("No %s material block found", material));
            return;
        }
        logger.info(String.format("Found %o blocks with %s material", targetBlocks.size(), material));
        targetBlocks.forEach(b -> logger.info(String.format("Material %s block hashCode: %o", material, b.hashCode())));
    }
}
