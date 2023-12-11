package com.horus.block;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Block implements IBlock {

    private String color;
    private String material;

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getMaterial() {
        return this.material;
    }
}
