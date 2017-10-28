package org.wonderland.alife.babel.engine.entities;

import org.wonderland.alife.babel.engine.entities.god.IGod;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by leon on 9/17/2017.
 */

public class Cell {

    private int x = 0;
    private int y = 0;

    private Map<Gene, Integer> dna;

    private IGod god;

    /**
     * Constructor
     *
     * @param x
     * @param y
     * @param dna
     */
    public Cell(int x, int y, Map<Gene, Integer> dna, IGod god) {
        this.x = x;
        this.y = y;
        this.dna = dna;
        this.god = god;
    }

    /**
     * Generate random DNA
     *
     * @param size
     * @return DNA map
     */




    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Map<Gene, Integer> getDna() {
        return dna;
    }

    public void setDna(Map<Gene, Integer> dna) {
        this.dna = dna;
    }

    public IGod getGod() {
        return god;
    }

    public void setGod(IGod god) {
        this.god = god;
    }
}