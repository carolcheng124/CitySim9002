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


    //seed is 9
//    private Generator generator = new Generator(9);

//    /**
//     * Test of randomType method, of class Generator.
//     * seed is 9 and bound is equal to the size of typeList
//     * Return true if RandomLocation() return a location within the locationList
//     */
//    @Test
//    public void testRandomTypeNum0() {
//        System.out.println("randomType Test");
//        Boolean toReturn = false;
//
//        String result = Generator.randomType();
//        for(int i = 0; i< typeList.length; i++){
//            if(result.equals(typeList[i])) toReturn = true;
//        }
//        assertTrue(toReturn);
//    }
//    
//    /**
//    * Five visitors should have different types as types are generated randomly
//    * Return true as types of five visitors are different
//    */
//    @Test
//    public void testRandomType1() {
//        System.out.println("randomType Test");
//        Boolean flag = true;
//        
//        String type1 = Generator.randomType();
//        for(int i = 0; i < 4; i++){
//            if(!type1.equals(Generator.randomType())) flag = true;
//        }
//        assertTrue(flag);
//
//    }
//
//
//    /**
//     * Test of randomLocation method, of class Generator.
//     * seed is 9 and bound is equal to the size of locationList
//     * Return true if RandomLocation() return a location within the locationList
//     */
//    @Test
//    public void testRandomLocation() {
//        Boolean toReturn = false;
//        
//        System.out.println("randomLocation Test");
//        int bound = locationList.length;
//        String result = Generator.randomLocation(bound);
//        for(int i = 0; i< locationList.length; i++){
//            if(result.equals(locationList[i])) toReturn = true;
//        }
//        assertTrue(toReturn);
//        
//    }
    
    
    
    
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
