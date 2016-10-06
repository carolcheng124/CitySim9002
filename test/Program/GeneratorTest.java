/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carol
 */
public class GeneratorTest {
    String[] locationList = {"Squirrel Hill", "Downtown", "The Point", "The Cathedral of Learning"};
    String[] typeList = {"Student", "Professor","Business Person", "Blogger"};
    Generator generator;
    int visitorNum;
    
    //seed is 9
    @Before
    public void setUp() throws Exception{
        generator = new Generator(9);
        visitorNum = 5;
    }
    
    @After
    public void tearDown() throws Exception{
    }
    
    
   /**
    * RANDOM TYPE TEST - 0
    * Test of randomType method, of class Generator.
    * Five visitors should have different types numbers as type numbers are generated randomly
    * Return true as types number of five visitors have difference
    */
    @Test
    public void testRandomType0() {
        Boolean difference = false;
        int[] typeNums = new int[visitorNum];
        
        for(int i = 0; i < visitorNum; i++){
            typeNums[i] = generator.randomTypeNum(typeList.length);
            if(typeNums[0] != typeNums[i]) difference = true;
        }
        
        assertTrue(difference);
    }
    
    /**
     * RANDOM TYPE TEST - 1
     * Test of randomType method, of class Generator.
     * random type numbers should be generated within the bound
     * Return true if each random numbers is less than the bound, which is the size of typeList
     */
    @Test
    public void testRandomTypeNum1() {
        Boolean toReturn = false;
        int[] typeNums = new int[visitorNum];
        
        for(int i = 0; i< visitorNum; i++){
            typeNums[i] = generator.randomTypeNum(typeList.length);
            if(typeNums[i] < typeList.length) toReturn = true;
        }
        
        assertTrue(toReturn);
    }
    



    /**
    * RANDOM LOCATION TEST - 0
    * Test of randomLocationNum method, of class Generator.
    * Five visitors should be assigned different location numbers as location numbers are generated randomly
    * Return true as location number of five visitors have difference
    */
    @Test
    public void testRandomLoactionNum0() {
        Boolean difference = false;
        int[] locationNums = new int[visitorNum];
        
        for(int i = 0; i < visitorNum; i++){
            locationNums[i] = generator.randomLocationNum(locationList.length);
            if(locationNums[0] != locationNums[i]) difference = true;
        }
        
        assertTrue(difference);
    }
    
    
    /**
     * RANDOM LOCATION TEST - 1
     * Test of randomLocation method, of class Generator.
     * random location numbers should be generated within the bound
     * Return true if each random numbers is less than the bound, which is the size of locationList
     */
    @Test
    public void testRandomLocationNum1() {
        Boolean toReturn = false;
        int[] locationNums = new int[visitorNum];
        
        for(int i = 0; i< visitorNum; i++){
            locationNums[i] = generator.randomLocationNum(locationList.length);
            if(locationNums[i] < locationList.length) toReturn = true;
        }
        
        assertTrue(toReturn);
    }
    
}
