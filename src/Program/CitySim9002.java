/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import Domain.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author AsphaltPanthers
 */
public class CitySim9002 {
    public static String errorMessage = "Please enter one integer argument, seed";
    public static List<Visitor> visitorList = new ArrayList<Visitor>();
    public static int seed;
    public static String[] typeList = {"Student", "Professor","Business Person", "Blogger"};
    public static String[] locationList = {"Squirrel Hill", "Downtown", "The Point", "The Cathedral of Learning", null};
   
    
    public static void main(String[] args) {
        //validation of arguments
        if (new Validator().validateArguments(args)) {
            seed = Integer.parseInt(args[0]);
            System.out.println("Welcome to CitySim!  Your seed is " + seed);
           // return 0;
        }
        else {
            System.out.println(errorMessage);
           // return -1;
        }
        
//      Generator generator = new Generator(seed);
        Generator generateType = new Generator(seed);
        Generator generateLocation = new Generator(seed);
        
        //five visitor iterations
        for(int i = 1; i <= 5; i++){
            Visitor curVisitor = new Visitor();
            visitorList.add(curVisitor);
            String nextLocation = "";
            
            //NO.1 set visitor's type
            String curType = curVisitor.getType(generateType, typeList.length);
            System.out.println("Visitor " + i + " is a " + curType);
            
            //set preference list
            curVisitor.getPreferenceList(curType);
            
            //NO.2 assign random location for each visitor
            while(curVisitor.getCurLocation() != null){ //leave the city as terminator
                if ("No location".equals(curVisitor.getCurLocation())) {
                    //visitor shouldn't leave for the first time
                     nextLocation = curVisitor.getNextLocation(generateLocation, locationList.length-1);
                }
                else{
                    //display the location
                    System.out.println("Visitor " + i + " is going to " + nextLocation);
                    
                    //like the location or not
                    if(curVisitor.likeOrNot(curVisitor.getCurLocation()))
                        System.out.println("Visitor " + i + " like " + curVisitor.getCurLocation());
                    else
                        System.out.println("Visitor " + i + " did not like " + curVisitor.getCurLocation());
                    
                    //random assign location from 4 places or leave the city
                    nextLocation = curVisitor.getNextLocation(generateLocation, locationList.length);
                
                }
            }
            
            //left the city
            System.out.println("Visitor " + i + " has left the city.");
            visitorList.remove(curVisitor);
            
            System.out.println("***********");
        }//for end
        
    }
}
