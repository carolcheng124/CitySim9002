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
import static org.mockito.Matchers.anyInt;
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
     * Set any generated random type number as 1
     * five visitors should have the same types as "Student"
     */
    @Test
    public void testGetType0() {
        Boolean same = false;
        
        Generator mockGenerator = mock(Generator.class);
        when(mockGenerator.randomTypeNum(anyInt())).thenReturn(0);
        
        Visitor[] visitors = new Visitor[visitorNum];
        
        
        for(int i = 0; i < visitorNum; i++){
            visitors[i] = new Visitor();
            String curType = visitors[i].getType(mockGenerator, typeList.length);
            if("Student".equals(curType)) same = true;
        }
        
        assertTrue(same);
    }
    
    /**
      * GET TYPE TEST - 1
     * Test of getType method, of class Visitor.
     * use real random generator to generate different type numbers
     * five visitors should have different types numbers
     * 
     */
    @Test
    public void testGetType1() {
        Boolean difference = false;
       
        Visitor[] visitors = new Visitor[visitorNum];
        Generator generator = new Generator(9);
        
        for(int i = 0; i < visitorNum; i++){
            visitors[i] = new Visitor();
            String curType = visitors[i].getType(generator, typeList.length);
            if(! visitors[0].type.equals(curType))  difference = true;
        }
    
        assertTrue(difference);
    }
    

    
    /**
     * GET NEXT LOCATION TEST - 0
     * Test of SetType method, of class Visitor.
     * Double + Stubbing
     * Mock the random generator
     * Set any generated random type number as 1
     * five visitors should have the same location as "Squirrel Hill"
     */
    @Test
    public void testGetNextLocation0() {
        Boolean same = false;
        
        Generator mockGenerator = mock(Generator.class);
        when(mockGenerator.randomLocationNum(anyInt())).thenReturn(0);
        
        Visitor[] visitors = new Visitor[visitorNum];
        
        
        for(int i = 0; i < visitorNum; i++){
            visitors[i] = new Visitor();
            String nextLocation = visitors[i].getNextLocation(mockGenerator, locationList.length);
            if("Squirrel Hill".equals(nextLocation)) same = true;
        }
        
        assertTrue(same);
    }
    
    /**
     * GET NEXT LOCATION TEST - 1
     * Test of getType method, of class Visitor.
     * use real random generator to generate different location numbers
     * five visitors should have different types numbers
     * 
     */
    @Test
    public void testGetNextLocation1() {
        Boolean difference = false;
       
        Visitor[] visitors = new Visitor[visitorNum];
        Generator generator = new Generator(9);
        
        for(int i = 0; i < visitorNum; i++){
            visitors[i] = new Visitor();
            String nextLocation = visitors[i].getNextLocation(generator, locationList.length);
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
     * Return true as visitor do like this location by likeOrNot()
     */
    @Test
    public void testLikeOrNot0() {
        
//        Visitor mockVisitor = mock(Visitor.class);
//        when(mockVisitor.getPreferenceList(any(String.class))).thenReturn(Arrays.asList("Squirrel Hill", "Downtown", "The Point"));
//        
        visitor.type = "Student";//double
        String location = "Downtown";
        visitor.getPreferenceList(visitor.type);

//when(visitor.getPreferenceList(any(String.class))).thenReturn(visitor.likeList = new ArrayList<String>(Arrays.asList("Squirrel Hill", "Downtown", "The Point")));//stubbing
//        
//        mockVisitor.likeList =v mockVisitor.getPreferenceList(type);
        assertTrue(visitor.likeOrNot(location));
        
    }
    
    /**
     * Double
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
        visitor.getPreferenceList(visitor.type);//stubbing
        
        assertFalse(visitor.likeOrNot(location));
        
    }
    
    
}
