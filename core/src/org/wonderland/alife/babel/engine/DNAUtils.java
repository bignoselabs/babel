package org.wonderland.alife.babel.engine;

import org.wonderland.alife.babel.engine.entities.Cell;
import org.wonderland.alife.babel.engine.entities.Gene;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by leon on 9/22/2017.
 */

public class DNAUtils {


    public static Map<Gene, Integer> generateDNA(int size, DNAGenerationMethod method) {
        switch (method) {
            case ONES:
                return generateOnesDna(size);
            case RANDOM:
                return generateRandomDna(size);
            case ZEROS:
                return generateZerosDna(size);
        }
        return generateRandomDna(Globals.INIT_DNA_SIZE);
    }

    private static Map<Gene, Integer> generateRandomDna(int size) {
        Map<Gene, Integer> randomDNA = new HashMap<Gene, Integer>();
        Random rnd = new Random();
        rnd.setSeed(System.nanoTime());
        for(int i = 0; i < size; i++) {
            randomDNA.put(new Gene(rnd.nextBoolean()), rnd.nextInt());
        }
        return randomDNA;
    }

    /**
     * Generate zero DNA
     *
     * @param size
     * @return DNA map
     */
    private static Map<Gene, Integer> generateZerosDna(int size) {
        Random rnd = new Random();
        Map<Gene, Integer> zerosDNA = new HashMap<Gene, Integer>();
        for(int i = 0; i < size; i++) {
            zerosDNA.put(new Gene(false), rnd.nextInt());
        }
        return zerosDNA;
    }

    /**
     * Generate one DNA
     *
     * @param size
     * @return DNA map
     */
    private static Map<Gene, Integer> generateOnesDna(int size) {
        Random rnd = new Random();
        Map<Gene, Integer> onesDNA = new HashMap<Gene, Integer>();
        for(int i = 0; i < size; i++) {
            onesDNA.put(new Gene(true), rnd.nextInt());
        }
        return onesDNA;
    }


    /**
     * Get DNA as string of bits
     *
     * @return DNA as base 2 number string
     */
    public static String getDnaAsBits(Cell cell) {
        StringBuffer sb = new StringBuffer();
        for(Map.Entry<Gene, Integer> gene : cell.getDna().entrySet()) {
            if(gene.getKey().getGene()) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        return sb.toString();
    }
}
