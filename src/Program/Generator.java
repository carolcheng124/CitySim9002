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
    public static Random generator;
//    public static String[] typeList = {"Student", "Professor","Business Person", "Blogger"};
//    public static String[] locationList = {"Squirrel Hill", "Downtown", "The Point", "The Cathedral of Learning", null};    
    
    public Generator(int seed){
        generator = new Random(seed);
    }
    
    
//    //random generator for visitor type
//    public static String randomType(){
//        return typeList[generator.nextInt(4)];
//    }
       
    
//    //random generator for location
//    public static String randomLocation(int bound){
//        return locationList[generator.nextInt(bound)];
//    }
    
    //random generator of number for visitor type
    public static int randomTypeNum(int bound){
          return generator.nextInt(bound);
    }
    
    //random generator for location within the bound
    public static int randomLocationNum(int bound){
        return generator.nextInt(bound);
    }
    
}
