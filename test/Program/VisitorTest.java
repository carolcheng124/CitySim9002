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
import static org.mockito.Matchers.any;
import org.mockito.Mockito;

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
//
//    /**
//     * SET TYPE TEST - 0
//     * Test of setType method, of class Visitor.
//     * 
//     */
//    @Test
//    public void testSetType() {
//        System.out.println("setType");
//        String type = "";
//        Visitor instance = new Visitor();
//        instance.setType(type);
//    }

    
    /**
     * SET TYPE TEST - 0
     * Test of SetType method, of class Visitor.
     * Double + Stubbing
     * Mock the random generator
     * Set any generated random type number as 1
     * five visitors should have the same types as "Student"
     */
    @Test
    public void testSetType0() {
        Boolean same = false;
        
        Generator mockGenerator = Mockito.mock(Generator.class);
        Mockito.when(mockGenerator.randomTypeNum(typeList.length)).thenReturn(0);
        
        Visitor[] visitors = new Visitor[visitorNum];
        
        
        for(int i = 0; i < visitorNum; i++){
            visitors[i] = new Visitor();
            String curType = visitors[i].setType(mockGenerator, typeList.length);
            if("Students".equals(curType)) same = true;
        }
        
        assertTrue(same);
    }
    
    /**
      * SET TYPE TEST - 1
     * Test of getType method, of class Visitor.
     * use real random generator to generate different type numbers
     * five visitors should have different types numbers
     * 
     */
    @Test
    public void testSetType1() {
        Boolean difference = false;
       
        Visitor[] visitors = new Visitor[visitorNum];
        Generator generator = new Generator(9);
        
        for(int i = 0; i < visitorNum; i++){
            visitors[i] = new Visitor();
            String curType = visitors[i].setType(generator, typeList.length);
            if(! visitors[0].type.equals(curType))  difference = true;
        }
    
        assertTrue(difference);
    }
    
    
//    /**
//     * Test of getLocation method, of class Visitor.
//     * Double + Stubbing
//     * Mock the random generator
//     * Set the return value as "Downtown"
//     * result should be as the same
//     */
//    @Test
//    public void testGetLocation() {
//        System.out.println("getLocation() Test"); 
//        
//        Generator mockGenerator = Mockito.mock(Generator.class);
//        Mockito.when(mockGenerator.randomLocation(5)).thenReturn("Downtown");
//        
//        visitor.setLocation(mockGenerator.randomLocation(5));
//        
//        String expResult = "Downtown";
//        String result = visitor.getLocation();
//        
//        assertEquals(expResult, result);
//    }

    
    /**
     * SET LOCATION TEST - 0
     * Test of SetType method, of class Visitor.
     * Double + Stubbing
     * Mock the random generator
     * Set any generated random type number as 1
     * five visitors should have the same location as "Squirrel Hill"
     */
    @Test
    public void testSetLocation0() {
        Boolean same = false;
        
        Generator mockGenerator = Mockito.mock(Generator.class);
        Mockito.when(mockGenerator.randomLocationNum(locationList.length)).thenReturn(0);
        
        Visitor[] visitors = new Visitor[visitorNum];
        
        
        for(int i = 0; i < visitorNum; i++){
            visitors[i] = new Visitor();
            String nextLocation = visitors[i].setLocation(mockGenerator, locationList.length);
            if("Squirrel Hill".equals(nextLocation)) same = true;
        }
        
        assertTrue(same);
    }
    
    /**
     * SET TYPE TEST - 1
     * Test of getType method, of class Visitor.
     * use real random generator to generate different location numbers
     * five visitors should have different types numbers
     * 
     */
    @Test
    public void testSetLocation1() {
        Boolean difference = false;
       
        Visitor[] visitors = new Visitor[visitorNum];
        Generator generator = new Generator(9);
        
        for(int i = 0; i < visitorNum; i++){
            visitors[i] = new Visitor();
            String nextLocation = visitors[i].setLocation(generator, locationList.length);
            if(! visitors[0].location.equals(nextLocation))  difference = true;
        }
    
        assertTrue(difference);
    }
    
  

    /**
     * LIKE OR NOT TEST - 0
     * Double + STUBBING
     * Test of likeOrNot method, of class Visitor.
     * Set the visitor's type to be a "Student"
     * Set the test location to be "Downtown"
     * Student is expected to like "downtown"
     * Return true as visitor do like this location by likeOrNot()
     */
    @Test
    public void testLikeOrNot0() {
        visitor.type = "Student";//double
        visitor.setPreferenceList(visitor.type);
//        Mockito.when(visitor.setPreferenceList(visitor.type))).thenReturn("Squirrel Hill", "Downtown", "The Point");//stubbing
        String location = "Downtown";
        
        assertTrue(visitor.likeOrNot(location));
        
    }
    
    /**
     * Double+stubbing
     * Test of likeOrNot method, of class Visitor.
     * Set the visitor's type to be a "Business person"
     * Set the test location to be "The Cathedral of Learning"
     * "Business person" should not like "The Cathedral of Learning"
     * Return false as visitor do not like this location by likeOrNot()
     */
    @Test
    public void testLikeOrNot1() {
        
        String location = "The Cathedral of Learning";
        visitor.type = "Business Person";//double
        visitor.setPreferenceList(visitor.type);//stubbing
        
        assertFalse(visitor.likeOrNot(location));
        
    }
    
    
}
