package org.wonderland.alife.babel.engine;

import org.wonderland.alife.babel.engine.entities.Cell;
import org.wonderland.alife.babel.engine.entities.god.BasicGodImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by leon on 9/17/2017.
 */

public enum Engine {
    INSTANCE;
    private static Random random = new Random(System.nanoTime());
    public static List<Cell> cells = new ArrayList<Cell>();

    public void initEngine(int initialPopulationSize) {
        for (int i = 0; i < initialPopulationSize; i++) {
            cells.add(new Cell(random.nextInt(Globals.MAX_WIDTH), random.nextInt(Globals.MAX_HEIGHT), DNAUtils.generateDNA(Globals.INIT_DNA_SIZE, DNAGenerationMethod.RANDOM), new BasicGodImpl()));
        }
    }


}
