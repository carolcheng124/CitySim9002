/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.Random;

/**
 *
 * @author Carol
 */
public class Generator {
    public Random generator;

    public Generator(int seed){
        generator = new Random(seed);
    }
    
    //assume seed is 9
    public Generator(){
        generator = new Random(9);
    }
    
    //random generator of number for visitor type
    public int randomTypeNum(int bound){
          return generator.nextInt(bound);
    }
    
    //random generator for location within the bound
    public int randomLocationNum(int bound){
        return generator.nextInt(bound);
    }
    
}
