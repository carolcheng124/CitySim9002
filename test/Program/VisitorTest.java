/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.Random;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Carol
 */
public class VisitorTest {
    String[] locationList = {"Squirrel Hill", "Downtown", "The Point", "The Cathedral of Learning"};
    String[] typeList = {"Student", "Professor","Business Person", "Blogger"};
    
    Visitor visitor;
    int visitorNum;
    
    @Before
    public void setUp() throws Exception{
        visitor = new Visitor();
        visitorNum = 5;
    }
    
    @After
    public void tearDown() throws Exception{
    }

    
    /**
     * GET TYPE TEST - 0
     * Test of SetType method, of class Visitor.
     * Double + Stubbing
     * Mock the random generator
     * Stubbing the nextInt method
     * Set any generated random number as 0
     * Return true if five visitors have the same type as "Students"
     */
    @Test
    public void testGetType0() {
        Boolean same = false;
        
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(any(int.class))).thenReturn(0);
//       !!!!!!
//       Generator mockGenerator = mock(Generator.class);
//       when(mockGenerator.randomTypeNum(typeList.length)).thenReturn(0);
            
        Visitor[] visitors = new Visitor[visitorNum];
        
        
        for(int i = 0; i < visitorNum; i++){
            visitors[i] = new Visitor();
//          String curType = visitors[i].getType(mockGenerator, typeList.length);
            String curType = visitors[i].getType(mockRandom, typeList.length);//!!!!
            if("Student".equals(curType)) same = true;
        }
        
        assertTrue(same);
    }
    
    /**
      * GET TYPE TEST - 1
     * Test of getType method, of class Visitor.
     * use real random generator to generate different numbers for visitors' types
     * Return true if five visitors have different types
     * 
     */
    @Test
    public void testGetType1() {
        Boolean same = true;
       
        Visitor[] visitors = new Visitor[visitorNum];
        Random random = new Random(9);
        //        Generator generator = new Generator(9);
        
        for(int i = 0; i < visitorNum; i++){
            visitors[i] = new Visitor();
//            String curType = visitors[i].getType(generator, typeList.length);
            String curType = visitors[i].getType(random, typeList.length);//!!!!
            if(! visitors[0].type.equals(curType))  same = false;
        }
    
        assertFalse(same);
    }
    

    
    /**
     * GET NEXT LOCATION TEST - 0
     * Test of SetType method, of class Visitor.
     * Double + Stubbing
     * Mock the random generator
     * Stubbing the nextIn method
     * Set any generated random type number as 0
     * Return true if five visitors have the same location as "Squirrel Hill"
     */
    @Test
    public void testGetNextLocation0() {
        Boolean same = false;
        
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(any(int.class))).thenReturn(0);
//        !!!!
//        Generator mockGenerator = mock(Generator.class);
//        when(mockGenerator.randomLocationNum(anyInt())).thenReturn(0);
        
        Visitor[] visitors = new Visitor[visitorNum];
        
        
        for(int i = 0; i < visitorNum; i++){
            visitors[i] = new Visitor();
            String nextLocation = visitors[i].getNextLocation(mockRandom, locationList.length);
            if("Squirrel Hill".equals(nextLocation)) same = true;
        }
        
        assertTrue(same);
    }
    
    /**
     * GET NEXT LOCATION TEST - 1
     * Test of getType method, of class Visitor.
     * use real random generator to generate different location numbers
     * return true if five visitors have different locations
     * 
     */
    @Test
    public void testGetNextLocation1() {
        Boolean difference = false;
       
        Visitor[] visitors = new Visitor[visitorNum];
//        Generator generator = new Generator(9);
        Random random = new Random(9);
        
        for(int i = 0; i < visitorNum; i++){
            visitors[i] = new Visitor();
//            String nextLocation = visitors[i].getNextLocation(generator, locationList.length);
            String nextLocation = visitors[i].getNextLocation(random, locationList.length);//!!!
            if(! visitors[0].location.equals(nextLocation))  difference = true;
        }
    
        assertTrue(difference);
    }
    
  

    /**
     * LIKE OR NOT TEST - 0
     * DOUBLE
     * Test of likeOrNot method, of class Visitor.
     * Set the visitor's type to be a "Student"
     * Set the test location to be "Downtown"
     * Student is expected to like "downtown"
     * Return true if visitor do like this location by likeOrNot()
     */
    @Test
    public void testLikeOrNot0() {
        //DOUBLE
        //assign visitor's type as "Students"
        visitor.type = "Student";
        String location = "Downtown";
        
        visitor.getPreferenceList(visitor.type);
        
        assertTrue(visitor.likeOrNot(location));
        
    }
    
    /**
     * Double
     * Test of likeOrNot method, of class Visitor.
     * Set the visitor's type to be a "Business person"
     * Set the test location to be "The Cathedral of Learning"
     * "Business person" should not like "The Cathedral of Learning"
     * Return false if visitor do not like this location by likeOrNot()
     */
    @Test
    public void testLikeOrNot1() {
        //DOUBLE
        //assign visitor's type as "Business Person"
        visitor.type = "Business Person";
        String location = "The Cathedral of Learning";
       
        visitor.getPreferenceList(visitor.type);//stubbing
        
        assertFalse(visitor.likeOrNot(location));
        
    }
    
    
}
